/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Receipt;

import com.myapp.struts.Invoice.InvoiceDAO;
import com.myapp.struts.Invoice.InvoiceForm;
import com.myapp.struts.Utility.ConnectionDao;
import com.myapp.struts.Utility.DropDownFill;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author prakash
 */
public class ReceiptDAO {
    
    private static final Logger log = Logger.getLogger(InvoiceDAO.class);
    
    public ReceiptDAO() {
        PropertyConfigurator.configure("log4j.Properties");
    }
    
    public void fillInvoiceNo(ReceiptForm form) {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        List<DropDownFill> dropDowList = null;
        try {
            
            con = ConnectionDao.getConnection();
            stmt = con.createStatement();
            
            dropDowList = new ArrayList<DropDownFill>();
            
            sql = "SELECT s.invoiceno,s.datetime,c.name FROM invoice s, contacts c where c.contactId=s.contactid order by invoiceno";
            
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                
                dropDowList.add(new DropDownFill(rs.getInt("invoiceno"), rs.getInt("invoiceno") + " / " + rs.getString("datetime") + " / " + rs.getString("name")));
                
            }
            
            form.setInvoiceNumbers(dropDowList);
            form.setInvoiceNo(form.getInvoiceNo());
            
        } catch (Exception e) {
            log.info("SQL exception fetching invoice no query:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {
            
            ConnectionDao.closeResources(con, stmt, rs);
        }
        
    }
    
    public void fillPaymentMode(ReceiptForm form) {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        List<DropDownFill> dropDowList = null;
        try {
            
            con = ConnectionDao.getConnection();
            stmt = con.createStatement();
            
            dropDowList = new ArrayList<DropDownFill>();
            
            sql = "select * from paymentmode";
            
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                
                dropDowList.add(new DropDownFill(rs.getInt("paymentmodeid"), rs.getString("paymentmodedescription")));
                
            }
            
            form.setPaymentMode(dropDowList);
          
            
        } catch (Exception e) {
            log.info("SQL exception fetching invoice no query:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {
            
            ConnectionDao.closeResources(con, stmt, rs);
        }
        
    }
    
    public void fillPaymentType(ReceiptForm form) {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        List<DropDownFill> dropDowList = null;
        try {
            
            con = ConnectionDao.getConnection();
            stmt = con.createStatement();
            
            dropDowList = new ArrayList<DropDownFill>();
            
            sql = "select * from paymenttypes";
            
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                
                dropDowList.add(new DropDownFill(rs.getInt("paymenttypeid"), rs.getString("description")));
                
            }
            
            form.setPaymentType(dropDowList);
          
            
        } catch (Exception e) {
            log.info("SQL exception fetching invoice no query:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {
            
            ConnectionDao.closeResources(con, stmt, rs);
        }
        
    }
    
    public static int getMaxReceiptID() {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
      int receiptId=0;
        try {
            
            con = ConnectionDao.getConnection();
            stmt = con.createStatement();
            
            sql = "select max(receiptid) as receiptId from receipt ";
            
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                
                receiptId =rs.getInt("receiptId");
            }
            
        
        } catch (Exception e) {
            log.info("SQL exception fetching getMaxReceiptID query:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {
            
            ConnectionDao.closeResources(con, stmt, rs);
        }
        return receiptId;
        
    }
    
    public void FillDetails(ReceiptForm form) {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        
        try {
            
            con = ConnectionDao.getConnection();
            stmt = con.createStatement();
            
            
            sql = "select C.name,V.description,I.amount,I.datetime,D.vehicleid from  contacts C,invoice I,invoicedetails D,vehicle V where C.contactId=I.contactid and I.invoiceno=D.invoiceno and D.vehicleid=V.vehicleid and I.invoiceno="+form.getInvoiceNo();
            
            rs = stmt.executeQuery(sql);
            form.setVehicle("");
            while (rs.next()) {
                form.setCustomerName(rs.getString("name"));
                if (form.getVehicle().equals("")) {
                    form.setVehicle(rs.getString("description")+" - "+rs.getString("vehicleid"));
                } else {
                    form.setVehicle(form.getVehicle()+" , " +rs.getString("description") +" - "+rs.getString("vehicleid"));
                }
               
               
                form.setAmount(rs.getInt("amount"));
                form.setInvoiceDate(rs.getString("datetime"));
                
                
            }
            
            
        } catch (Exception e) {
            log.info("SQL exception fetching FillDetails no query:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {
            
            ConnectionDao.closeResources(con, stmt, rs);
        }
        
    }
    
    public void insertToReceipt(ReceiptForm form,int contactId) {
        String sql = "";
       
        Connection con = null;
        Statement stmt = null;
        ResultSet rs=null;
        
        try {
            
            con = ConnectionDao.getConnection();
            stmt = con.createStatement();
            
         form.setAmountInWordsR(form.getAmountWords());
            sql = "insert into receipt(datetime,invoiceno,creatorid,remarks,amount,vehicledetails,paymentmodeid,paymenttypeid,customername,amountinwords)values('"+form.getReceiptDate()+"',"+form.getInvoiceNo()+","+contactId+",'"+form.getRemarks()+"',"+form.getAmount()+",'"+form.getVehicle()+"',"+form.getSelectedPaymentMode()+","+form.getSelectedPaymentType()+",'"+form.getCustomerName()+"','"+form.getAmountWords()+"')";
            
//            stmt.executeUpdate(sql);
            
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
             rs = stmt.getGeneratedKeys();

            while (rs.next()) {
                 form.setReceiptNo(rs.getInt(1));
                 form.setReceiptNoR(rs.getInt(1));
            }
            
        } catch (Exception e) {
            log.info("SQL exception  insertToReceipt no query:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {
            
            ConnectionDao.closeResources(con, stmt,rs);
        }
        
    }
    
    public void Reportdetails(ReceiptForm form) {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        
        try {
            
            con = ConnectionDao.getConnection();
            stmt = con.createStatement();
            
            
            sql = "select i.datetime,r.datetime,r.receiptid,r.invoiceno,r.remarks,r.amount,r.vehicledetails,c.name from receipt r,invoice i,Contacts c where c.contactId=r.creatorid and i.invoiceno=r.invoiceno";
            
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                form.setRamount(rs.getDouble("recieptamount"));
               
                form.setRdate(rs.getString("receiptdate"));
                form.setRremarks(rs.getString("remarks"));
                form.setRno(rs.getInt("receiptid"));
                form.setIno(rs.getInt("invoiceno"));
                form.setIdate(rs.getString("datetime"));
                form.setCname(rs.getString("name"));
                form.setVehicleDetail(rs.getString("vehicledetails"));
                
                
                
            }
            
            
        } catch (Exception e) {
            log.info("SQL exception fetching FillDetails no query:" + sql + "\n" + e.getMessage());
            e.printStackTrace();
        } finally {
            
            ConnectionDao.closeResources(con, stmt, rs);
        }
        
    }
    
    public void printTheReceipt(ReceiptForm form) {
        String sql = "";
        ResultSet rs = null;
        Connection con = null;
        Statement stmt = null;
        ;
        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();


            
            
//            sql = "select * from receipt R,vehicle,paymentmode M,paymenttypes P where R.paymenttypeid=P.paymenttypeid and R.paymentmodeid=M.paymentmodeid and R.receiptno="+form.getReceiptNo();
//;

 sql = "select r.receiptno,r.vehicledetails,r.amount,r.datetime,r.amountinwords,r.customername,pm.paymentmodedescription,pt.description from receipt r,paymentmode pm,paymenttypes pt where receiptno="+form.getReceiptNo()+" and pm.paymentmodeid =r.paymentmodeid and pt.paymenttypeid=r.paymenttypeid";

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
