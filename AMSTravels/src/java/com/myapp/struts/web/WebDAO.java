/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.web;

import com.myapp.struts.Invoice.*;
import com.myapp.struts.Settings.SettingsForm;
import com.myapp.struts.Utility.ConnectionDao;
import com.myapp.struts.Utility.DropDownFill;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author prakash
 */
public class WebDAO {

    private static final Logger log = Logger.getLogger(WebDAO.class);

    public WebDAO() {
        PropertyConfigurator.configure("log4j.Properties");
    }

    public void fillVehicle(webForm form) {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        List<DropDownFill> dropDowList = null;
        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();

            dropDowList = new ArrayList<DropDownFill>();

            sql = "select * from vehicle order by description";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                dropDowList.add(new DropDownFill(rs.getInt("vehicleid"), rs.getString("description")));

            }

            form.setVehicles(dropDowList);
            form.setCheckedVehicle(form.getCheckedVehicle());

        } catch (Exception e) {
            log.info("SQL exception fetching Vehicle ery:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {

            ConnectionDao.closeResources(con, stmt, rs);
        }

    }

    public int insertUserDetails(webForm form) throws SQLException {
        String sql = "";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
       
        int contctID = 0;
        int invoiceID = 0;  
      
        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();


            sql = "insert into contacts(name,address,remarks,mobileNo,createddate,emailid)values('" + form.getName() + "','" + form.getAddress() + "',null,'" + form.getContactno() + "',now(),'" + form.getEmail() + "')";
            log.info("query--" + sql);

            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

             rs = stmt.getGeneratedKeys();
            while(rs.next()){
                contctID=rs.getInt(1);
            }
            
            String str= new SimpleDateFormat("yyyy/MM/dd").format(new java.util.Date());
            
            String sql2 = "insert into user(username,password,contactid,active,createddate,remarks,admin)values('" + form.getUserName() + "','" + form.getPassword() + "'," + contctID + "," + 3 + ",'" + str + "',null,false)";
            stmt.executeUpdate(sql2);

        } catch (Exception e) {
            log.info(e + sql);

        } finally {
            ConnectionDao.closeResources(con, stmt,rs);

        }
        return contctID;

    }

    public void inserttoContactInvoiceInvoiceDetailsInvoiceOtherChargeDetails(InvoiceForm form, int userId) throws SQLException {
        String sql = "";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int contctID = 0;
        int invoiceID = 0;
        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();




            sql = "insert into contacts(name,address,remarks,mobileNo,createddate,emailid)values('" + form.getCustomerName() + "','" + form.getAddress() + "','" + form.getDescription() + "','" + form.getMobileNo() + "',now(),'" + form.getEmailID() + "')";
            log.info("query--" + sql);

            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            rs = stmt.getGeneratedKeys();

            while (rs.next()) {
                contctID = rs.getInt(1);
            }


            String sql2 = "insert into invoice(contactid,datetime,creatorid,amount,remarks,amountinwords)values(" + contctID + ",'" + form.getInvoiceDate() + "'," + userId + "," + form.getGrandTotal() + ",'" + form.getDescription() + "','" + form.getAmountInWords() + "')";
            stmt.executeUpdate(sql2, Statement.RETURN_GENERATED_KEYS);


            rs = stmt.getGeneratedKeys();

            while (rs.next()) {
                invoiceID = rs.getInt(1);
                form.setInvoiceNoR(invoiceID);
            }

            for (int i = 0; i < form.getInvoiceList().size(); i++) {
                String sql3 = "insert into invoicedetails(invoiceno,vehicleid,kms,perkmrate,amount,fromdate,todate,placesofvisit,vehicleno)values(" + invoiceID + "," + form.getInvoiceList().get(i).getSelectedVehicleId() + "," + form.getInvoiceList().get(i).getKm() + "," + form.getInvoiceList().get(i).getRate() + "," + form.getInvoiceList().get(i).getAmount() + ",'" + form.getInvoiceList().get(i).getFromDate() + "','" + form.getInvoiceList().get(i).getToDate() + "','" + form.getInvoiceList().get(i).getVisitPlace() + "','" + form.getInvoiceList().get(i).getVehicleNo() + "')";
                stmt.executeUpdate(sql3);
            }
            for (int i = 0; i < form.getChargeDetailsList().size(); i++) {
                String sql4 = "insert into invoiceothercharges(otherchargetypeid,invoiceno,amount)values(" + form.getChargeDetailsList().get(i).getRowIDOtherCharge() + "," + invoiceID + "," + form.getChargeDetailsList().get(i).getOtherChargeAmount() + ")";
                stmt.executeUpdate(sql4);
            }

        } catch (Exception e) {
            log.info("SQL exception while inserting Invoices and contact \n query:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {
            rs.close();
            ConnectionDao.closeResources(con, stmt);

        }

    }

  

    public void printFirstPart(InvoiceForm form) {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        ;
        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();




            sql = "select C.name,C.address,C.mobileNo,I.invoiceno,I.datetime,I.remarks,I.amount,I.amountinwords from  invoice I,contacts C where I.contactid=C.contactId and I.invoiceno=" + form.getMaxInvoiceID();

            rs = stmt.executeQuery(sql);

            if (rs.next()) {

                form.setCustomerNameR(rs.getString("name"));
                form.setInvoiceDateR(rs.getString("datetime"));
                form.setAddressR(rs.getString("address"));
                form.setMobileNoR(rs.getString("mobileNo"));
                form.setInvoiceNoR(rs.getInt("invoiceno"));
                form.setDescriptionR(rs.getString("remarks"));
                form.setGrandTotalR(rs.getInt("amount"));
                form.setAmountInWordsR(rs.getString("amountinwords"));



            }



        } catch (Exception e) {
            log.info("SQL exception printFirstPart:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {

            ConnectionDao.closeResources(con, stmt, rs);
        }

    }

    public void printSecondPart(InvoiceForm form) {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        ;
        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();


            sql = "select * from invoicedetails I,vehicle V where I.vehicleid=V.vehicleid and  invoiceno=" + form.getMaxInvoiceID();

            rs = stmt.executeQuery(sql);

            form.getInvoiceListR().clear();
            while (rs.next()) {


                InvoiceData temp = new InvoiceData();

                temp.setFromDate(rs.getString("FromDate"));
                temp.setToDate(rs.getString("ToDate"));

                temp.setVehicleNo(rs.getString("vehicleno"));
                temp.setKm(rs.getFloat("kms"));
                temp.setRate(rs.getInt("perkmrate"));
                temp.setAmount(rs.getInt("amount"));
                temp.setVisitPlace(rs.getString("placesofvisit"));
                temp.setVehicle(rs.getString("description"));

                form.getInvoiceListR().add(temp);

            }



        } catch (Exception e) {
            log.info("SQL exception printFirstPart:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {

            ConnectionDao.closeResources(con, stmt, rs);
        }

    }

    public void printThridPart(InvoiceForm form) {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        ;
        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();


            sql = "select otherchargetypeid,invoiceno,amount,(select description from othercharges where otherchargesid=I.otherchargetypeid) description from invoiceothercharges I where  invoiceno=" + form.getMaxInvoiceID();

            rs = stmt.executeQuery(sql);

            form.getChargeDetailsListR().clear();
            while (rs.next()) {



                ChargeData temp = new ChargeData();

                temp.setOtherCharges(rs.getString("description"));

                temp.setOtherChargeAmount(rs.getInt("amount"));


                form.getChargeDetailsListR().add(temp);

            }



        } catch (Exception e) {
            log.info("SQL exception printFirstPart:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {

            ConnectionDao.closeResources(con, stmt, rs);
        }

    }
}
