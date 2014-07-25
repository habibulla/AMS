/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.Utility;

import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import com.sun.mail.smtp.SMTPAddressFailedException;
import com.sun.mail.smtp.SMTPAddressSucceededException;
import com.sun.mail.smtp.SMTPSendFailedException;
import com.sun.mail.smtp.SMTPTransport;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author ptechadmin
 */
public class mailsending {

    public void Backupdbtosql() throws IOException, InterruptedException {
        try {
            Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 5.5\\bin\\mysqldump -u root -pjavaapp asmmotors -r C:/backup.sql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String sendMail(String ContactEmailAddress, String subject, String message) {

        String password = "developers123";
        String from = "shy.developers@gmail.com";
        String cc = "";
        String to = ContactEmailAddress;

        String mailhost = "smtp.mail.gmail.com";
        String user = "shy.developers@gmail.com";

        String retMsg = " ";

        boolean auth = true;
        boolean ssl = false;
        Properties props = System.getProperties();
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.port", "587");
//        if (mailhost != null) {
//            props.put("mail.smtp.host", mailhost);
//        }
//        if (auth) {
//            props.put("mail.smtp.auth", "true");
//        }

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
        "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");


        // Get a Session object
        javax.mail.Session session = javax.mail.Session.getInstance(props, null);
        // Construct the message
        javax.mail.Message msg = new MimeMessage(session);
        try {
            // Set message details
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));

            StringTokenizer strcc = new StringTokenizer(cc, ",");

            while (strcc.hasMoreTokens()) {
                String temp = strcc.nextToken();
                msg.setRecipient(javax.mail.Message.RecipientType.CC, new InternetAddress(temp));
            }

            String[] temp = null;

            temp = message.split(",");

            Multipart multipart = new MimeMultipart("related");

            for (int i = 0; i < temp.length; i++) {
//            htmlPart.setContent("<html><body>" + message + "<br><img src=\"http://www.e.com/images/Ec-TM.jpg\"/><br/>" + "</body></html>", "text/html");
                BodyPart htmlPart = new MimeBodyPart();

                htmlPart.setContent("<html><body><font color=red>" + temp[i] + "<br/>" + "</font></body></html>", "text/html");

                multipart.addBodyPart(htmlPart);
            }

            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setContent(multipart);

            // Send the thing off
            SMTPTransport t = (SMTPTransport) session.getTransport(ssl ? "smtps" : "smtp");
            try {
                if (auth) {
                    t.connect(mailhost, user, password);
                } else {
                    t.connect();
                }
                t.sendMessage(msg, msg.getAllRecipients());
            } finally {
                t.close();
            }
            retMsg = "Mail was sent successfully.";
        } catch (Exception e) {
            if (e instanceof SendFailedException) {
                MessagingException sfe = (MessagingException) e;
                if (sfe instanceof SMTPSendFailedException) {
                    SMTPSendFailedException ssfe = (SMTPSendFailedException) sfe;
                    retMsg = "Smtp_Send_Failed:";
                }
                Exception ne;
                while ((ne = sfe.getNextException()) != null && ne instanceof MessagingException) {
                    sfe = (MessagingException) ne;
                    if (sfe instanceof SMTPAddressFailedException) {
                        SMTPAddressFailedException ssfe = (SMTPAddressFailedException) sfe;
                        retMsg = "Address failed:";
                        retMsg = retMsg + "  Address: " + ssfe.getAddress();
                        retMsg = retMsg + "  Command: " + ssfe.getCommand();
                        retMsg = retMsg + "  Return Code: " + ssfe.getReturnCode();
                        retMsg = retMsg + "  Response: " + ssfe.getMessage();
                    } else if (sfe instanceof SMTPAddressSucceededException) {
                        retMsg = retMsg + "Address succeeded:";
                        SMTPAddressSucceededException ssfe = (SMTPAddressSucceededException) sfe;
                    }
                }
            } else {
                retMsg = retMsg + "Got Exception : " + e;
            }
        }
        return retMsg;
    }

    //
    public String sendMailWithAttachment(String ContactEmailAddress, String subject, String filePath, String message) {

        String password = "developers123";
        String from = "shy.developers@gmail.com";
        String cc = "";
        String to = ContactEmailAddress;

        String mailhost = "smtp.gmail.com";
        String user = "shy.developers@gmail.com";

        String retMsg = " ";

        boolean auth = true;
        boolean ssl = false;
        Properties props = System.getProperties();
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.port", "587");
//        if (mailhost != null) {
//            props.put("mail.smtp.host", mailhost);
//        }
//        if (auth) {
//            props.put("mail.smtp.auth", "true");
//        }

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Get a Session object
        javax.mail.Session session = javax.mail.Session.getInstance(props, null);
        // Construct the message
        javax.mail.Message msg = new MimeMessage(session);
        try {
            // Set message details
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));

            StringTokenizer strcc = new StringTokenizer(cc, ",");

            while (strcc.hasMoreTokens()) {
                String temp = strcc.nextToken();
                msg.setRecipient(javax.mail.Message.RecipientType.CC, new InternetAddress(temp));
            }

            Multipart multipart = new MimeMultipart("related");
//            
            BodyPart htmlPart = new MimeBodyPart();

            htmlPart.setContent("<html><body><font color=red>" + message + "<br/>" + "</font></body></html>", "text/html");

            MimeBodyPart messageBodyPart = new MimeBodyPart();

            String filename = filePath;//change accordingly
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);

            multipart.addBodyPart(htmlPart);
            multipart.addBodyPart(messageBodyPart);

            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setContent(multipart);

            // Send the thing off
            SMTPTransport t = (SMTPTransport) session.getTransport(ssl ? "smtps" : "smtp");
            try {
                if (auth) {
                    t.connect(mailhost, user, password);
                } else {
                    t.connect();
                }
                t.sendMessage(msg, msg.getAllRecipients());
            } finally {
                t.close();
            }
            retMsg = "Mail was sent successfully.";
        } catch (Exception e) {
            if (e instanceof SendFailedException) {
                MessagingException sfe = (MessagingException) e;
                if (sfe instanceof SMTPSendFailedException) {
                    SMTPSendFailedException ssfe = (SMTPSendFailedException) sfe;
                    retMsg = "Smtp_Send_Failed:";
                }
                Exception ne;
                while ((ne = sfe.getNextException()) != null && ne instanceof MessagingException) {
                    sfe = (MessagingException) ne;
                    if (sfe instanceof SMTPAddressFailedException) {
                        SMTPAddressFailedException ssfe = (SMTPAddressFailedException) sfe;
                        retMsg = "Address failed:";
                        retMsg = retMsg + "  Address: " + ssfe.getAddress();
                        retMsg = retMsg + "  Command: " + ssfe.getCommand();
                        retMsg = retMsg + "  Return Code: " + ssfe.getReturnCode();
                        retMsg = retMsg + "  Response: " + ssfe.getMessage();
                    } else if (sfe instanceof SMTPAddressSucceededException) {
                        retMsg = retMsg + "Address succeeded:";
                        SMTPAddressSucceededException ssfe = (SMTPAddressSucceededException) sfe;
                    }
                }
            } else {
                retMsg = retMsg + "Got Exception : " + e;
            }
        }
        return retMsg;
    }
}
