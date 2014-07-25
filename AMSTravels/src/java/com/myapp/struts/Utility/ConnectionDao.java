/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Utility;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author prasanna
 */
public class ConnectionDao {

    private static final Logger log = Logger.getLogger(ConnectionDao.class);

    public ConnectionDao() {
        PropertyConfigurator.configure("log4j.Properties");

    }

  
    public static Connection getConnection() throws Exception {

//        String url = "jdbc:mysql://ec2-23-21-211-172.compute-1.amazonaws.com:3306/asmmotors";
//        Class.forName("com.mysql.jdbc.Driver").newInstance();
//        Connection connect = DriverManager.getConnection(url, "adminams", "javaapp");

        String url = "jdbc:mysql://localhost:3306/asmmotors";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection connect = DriverManager.getConnection(url, "root", "!@#jtq123");
        return connect;
    }

    public static void closeResources(Connection conn, Statement st, ResultSet rs) {
        try {
            System.out.print("now closing statement -------------");
            log.info("now closing statement -------------");
            st.close();
            st = null;
            System.out.print("now closing ResultSet -------------");
            log.info("now closing ResultSet -------------");
            rs.close();
            rs = null;
            System.out.println("now closing Connection ------------");
            log.info("now closing Connection ------------");
            conn.close();
            conn = null;
        } catch (Exception e) {
            System.out.println("Some exception closing resources ---------\n" + e.getMessage());
            log.info("Some exception closing resources ---------\n" + e.getMessage());
        }
    }

    public static void closeResources(Connection conn, Statement st) {
        try {
            System.out.print("now closing statement -------------");
            log.info("now closing statement -------------");
            st.close();
            st = null;
            System.out.println("now closing Connection ------------");
            log.info("now closing Connection ------------");
            conn.close();
            conn = null;
        } catch (Exception e) {
            System.out.println("Some exception closing resources ---------\n" + e.getMessage());
            log.info("Some exception closing resources ---------\n" + e.getMessage());
        }
    }
}
