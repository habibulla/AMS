/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts.booking;

import com.myapp.struts.Utility.ConnectionDao;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Habibulla
 */
public class fetchimage extends HttpServlet {

  
    private static final long serialVersionUID = 4593558495041379082L;

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        Statement stmt = null;
        ResultSet rs;
        InputStream sImage;
        String filename = null;
        Connection Con=null;
        try {

            ServletContext context = getServletConfig().getServletContext();

            String id = request.getParameter("vehicleid");
            System.out.println("inside servlet–>" + id);
            Con = ConnectionDao.getConnection();
            stmt = Con.createStatement();
//            stmt = con.createStatement();
            String strSql = "select * from vehicle where vehicleid=" + Integer.parseInt(id) + "";
            rs = stmt.executeQuery(strSql);

            if (rs.next()) {
                byte[] bytearray = new byte[1048576];
                int size = 0;
                sImage = rs.getBinaryStream("path");
                filename = rs.getString("vehicleid");
                String mimetype = context.getMimeType(filename);
                response.setContentType("application/force-download");
                response.addHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

                while ((size = sImage.read(bytearray)) != -1) {
                    response.getOutputStream().
                            write(bytearray, 0, size);
                }
                response.flushBuffer();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
