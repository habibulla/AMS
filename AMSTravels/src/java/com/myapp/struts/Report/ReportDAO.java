/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Report;

import com.myapp.struts.Invoice.ChargeData;
import com.myapp.struts.Invoice.InvoiceDAO;
import com.myapp.struts.Invoice.InvoiceData;
import com.myapp.struts.Invoice.InvoiceForm;
import com.myapp.struts.Utility.ConnectionDao;
import com.myapp.struts.Utility.DropDownFill;
import com.myapp.struts.Utility.stringconstant;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author prakash
 */
public class ReportDAO {

    private static final Logger log = Logger.getLogger(InvoiceDAO.class);

    public ReportDAO() {
        PropertyConfigurator.configure("log4j.Properties");
    }

    public void searchreportdetails(ReportForm form, String reportType, String fromDate, String toDate) throws SQLException {
        String sql = "";
        ResultSet rs = null;
        ResultSet rs1 = null;
        Connection con = null;
        Statement stmt = null;
        Statement stmt1 = null;

        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();
            stmt1 = con.createStatement();

            sql = "select * from " + reportType + " where datetime>='" + fromDate + "' and datetime <='" + toDate + "' and cancelled=0";

            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ReportType_Bean objReportDetails = new ReportType_Bean();

                objReportDetails.setAmount(rs.getDouble("amount"));
                objReportDetails.setDocumentDate(rs.getString("datetime"));
                objReportDetails.setDescription(rs.getString("remarks"));

                if (reportType.equals(stringconstant.shyReceipt)) {
                    objReportDetails.setDocumentNo(rs.getInt("receiptno"));
                    objReportDetails.setCustomerName(rs.getString("customername"));
                } else if (reportType.equals(stringconstant.shyInvoice)) {
                    objReportDetails.setDocumentNo(rs.getInt("invoiceno"));

                    rs1 = stmt1.executeQuery("select name from contacts where contactid in (select contactid from invoice where invoiceno = " + rs.getInt(1) + ")");

                    while (rs1.next()) {
                        objReportDetails.setCustomerName(rs1.getString("name"));
                    }


                }


                form.getReportDetails().add(objReportDetails);
            }




        } catch (Exception e) {
            log.info("SQL exception fetching Vehicle ery:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (rs1 != null) {
                rs1.close();
                stmt1.close();
            }
            ConnectionDao.closeResources(con, stmt, rs);
        }

    }

    public void updateCancelled(String reportType, int cancelleedParam, int documentNo) throws SQLException {
        String sql = "";


        Connection con = null;
        Statement stmt = null;


        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();


            if (reportType.equalsIgnoreCase(stringconstant.shyReceipt)) {
                sql = "update " + reportType + " set  cancelled=" + cancelleedParam + " where receiptno= " + documentNo;
            } else if (reportType.equalsIgnoreCase(stringconstant.shyInvoice)) {
                sql = "update " + reportType + " set  cancelled=" + cancelleedParam + " where invoiceno = " + documentNo;

            }
            stmt.executeUpdate(sql);





        } catch (Exception e) {
            log.info("SQL exception fetching Vehicle ery:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {

            ConnectionDao.closeResources(con, stmt);
        }

    }

    public void printFirstPart(ReportForm form, int documentNo) {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        ;
        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();




            sql = "select C.name,C.address,C.mobileNo,I.invoiceno,I.datetime,I.remarks,I.amount,I.amountinwords from  invoice I,contacts C where I.contactid=C.contactId and I.invoiceno=" + documentNo;

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

    public void printSecondPart(ReportForm form, int documentNo) {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();


            sql = "select * from invoicedetails I,vehicle V where I.vehicleid=V.vehicleid and  invoiceno=" + documentNo;

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

    public void printThridPart(ReportForm form, int documentNo) {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;

        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();


            sql = "select otherchargetypeid,invoiceno,amount,(select description from othercharges where otherchargesid=I.otherchargetypeid) description from invoiceothercharges I where  invoiceno=" + documentNo;

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

    public void printFirstPartforreceipt(ReportForm form, int documentNo) {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;

        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();




            sql = "select r.receiptno,r.vehicledetails,r.amount,r.datetime,r.amountinwords,r.customername,pm.paymentmodedescription,pt.description from receipt r,paymentmode pm,paymenttypes pt where receiptno="+documentNo+" and pm.paymentmodeid =r.paymentmodeid and pt.paymenttypeid=r.paymenttypeid";

            rs = stmt.executeQuery(sql);

            if (rs.next()) {

                form.setCustomerNameR(rs.getString("customername"));
                form.setReceiptDateR(rs.getString("datetime"));
                form.setPaymentModeR(rs.getString("paymentmodedescription"));
                form.setPaymentTypeR(rs.getString("description"));
                form.setReceiptNoR(rs.getInt("receiptno"));
                form.setVehicleR(rs.getString("vehicledetails"));
                form.setAmountR(rs.getInt("amount"));
                form.setAmountInWordsR(rs.getString("amountinwords"));



            }



        } catch (Exception e) {
            log.info("SQL exception printFirstPart:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {

            ConnectionDao.closeResources(con, stmt, rs);
        }

    }
}
