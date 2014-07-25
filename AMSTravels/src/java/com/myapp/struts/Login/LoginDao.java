/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Login;

import com.myapp.struts.Login.UserInfo;
import com.myapp.struts.Utility.ConnectionDao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Kaushi
 */
public class LoginDao {

  

    public LoginDao() {
    

    }

    public UserInfo validateForm(LoginForm form) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "";
        UserInfo objUserInfo = null;
        try {

            con = ConnectionDao.getConnection();
            st = con.createStatement();
            sql = "select * from user where active=1 and username='" + form.getUserName() + "' and password='" + form.getPassword() + "'";
            rs = st.executeQuery(sql);
            

            while (rs.next()) {

                objUserInfo=new UserInfo();

                objUserInfo.setAdminFlag((rs.getInt("admin") == 1 ? true : false));
                objUserInfo.setUserName(rs.getString("username"));
                objUserInfo.setPassword(rs.getString("contactid"));




            }




        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }

 return objUserInfo;


    }
}
