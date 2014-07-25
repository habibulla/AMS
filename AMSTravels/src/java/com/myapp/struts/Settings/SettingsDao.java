/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Settings;

import com.myapp.struts.Invoice.InvoiceDAO;
import com.myapp.struts.Utility.ConnectionDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.crypto.Data;
import org.apache.log4j.Logger;

/**
 *
 * @author Kaushi
 */
public class SettingsDao {

    private static final Logger log = Logger.getLogger(InvoiceDAO.class);
    String sql = "";

    public void insertVehicle(String vehicleName, String remarks) throws SQLException {
        Connection con = null;
        Statement stmt = null;


        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();


            sql = "insert into vehicle(description,vehicletypeid,remarks)values('" + vehicleName + "',1,'" + remarks + "')";
            stmt.executeUpdate(sql);

        } catch (Exception e) {

            log.info(e + sql);
        } finally {


            ConnectionDao.closeResources(con, stmt);

        }

    }

    public void insertOtherChargeTypes(String otherCharge) throws SQLException {
        String sql = "";
        Connection con = null;
        Statement stmt = null;


        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();


            sql = "insert into othercharges(description) values('" + otherCharge + "')";
            stmt.executeUpdate(sql);

        } catch (Exception e) {

            log.info(e + sql);
        } finally {


            ConnectionDao.closeResources(con, stmt);

        }

    }

    public void insertUserDetails(SettingsForm form) throws SQLException {
        String sql = "";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int contctID = 0;
        int invoiceID = 0;
        try {

            con = ConnectionDao.getConnection();
            stmt = con.createStatement();


            sql = "insert into contacts(name,address,remarks,mobileNo,createddate,emailid)values('" + form.getName() + "','" + form.getAddress() + "','" + form.getRemarks() + "','" + form.getMobileNo() + "',now(),'" + form.getEmailID() + "')";
            log.info("query--" + sql);

            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

             rs = stmt.getGeneratedKeys();
            while(rs.next()){
                contctID=rs.getInt(1);
            }
            
            String str= new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            
            String sql2 = "insert into user(username,password,contactid,active,createddate,remarks,admin)values('" + form.getUserName() + "','" + form.getPassword() + "'," + contctID + "," + 1 + ",'" + str + "','" + form.getRemarks() + "'," + form.isAdmin() + ")";
            stmt.executeUpdate(sql2);

        } catch (Exception e) {
            log.info(e + sql);

        } finally {
            ConnectionDao.closeResources(con, stmt,rs);

        }

    }

    public void updatePassword(String userName, String password) throws SQLException {
        String sql = "";
        Connection con = null;
        Statement stmt = null;


        try {
            con = ConnectionDao.getConnection();
            stmt = con.createStatement();
            sql = "update user set password='" + password + "' where username='" + userName + "'";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            log.info(e + sql);
        } finally {


            ConnectionDao.closeResources(con, stmt);

        }

    }

    public boolean checkForUserName(String userName) throws SQLException {
        String sql = "";
        boolean userexists = false;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;


        try {
            con = ConnectionDao.getConnection();
            stmt = con.createStatement();
            sql = "select * from user where username='" + userName + "'";
            rs = stmt.executeQuery(sql);

        } catch (Exception e) {
            log.info(e + sql);
        } finally {

            while (rs.next()) {
                userexists = true;
            }

            ConnectionDao.closeResources(con, stmt, rs);
            return userexists;
        }

    }
    
      public boolean checkForPassword(String userName,String Password) throws SQLException {
        String sql = "";
        boolean userexists = false;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;


        try {
            con = ConnectionDao.getConnection();
            stmt = con.createStatement();
            sql = "select * from user where username='" + userName + "' and password='"+ Password +"'";
            rs = stmt.executeQuery(sql);

        } catch (Exception e) {
            log.info(e + sql);
        } finally {

            while (rs.next()) {
                userexists = true;
            }

            ConnectionDao.closeResources(con, stmt, rs);
            return userexists;
        }

    }
}
