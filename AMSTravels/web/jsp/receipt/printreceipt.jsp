
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta http-equiv="Context-Type" content="text/html; charset=US-ASCII">
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />

        <title>
            AMS Tours And Travels
        </title>

        <script type='text/javascript' src="calender/js/zapatec.js"></script>
        <script type="text/javascript" src="calender/js/calendar.js"></script>
        <script type="text/javascript" src="calender/js/calendar-en.js"></script>
        <script type="text/javascript" src="script/allscripts.js"></script>
        <link href="calender/css/zpcal.css" rel="stylesheet" type="text/css"/>
        <link href="calender/themes/aqua.css" rel="stylesheet" type="text/css"/>

        <style type="text/css">
            body {
                padding-top: 160px;
                padding-bottom: 40px;
                background-color: #fff;
            }

            .form-signin {
                max-width: 360px;
                padding: 19px 29px 29px;
                margin: 0 auto 20px;
                background-color: #fff;
                border: 1px solid #e5e5e5;
                -webkit-border-radius: 5px;
                -moz-border-radius: 5px;
                border-radius: 5px;
                -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
            }
            .form-signin .form-signin-heading,
            .form-signin .checkbox {
                margin-bottom: 10px;
            }
            .form-signin .checkbox {
                font-weight: normal;
            }
            .form-signin .form-control {
                position: relative;
                font-size: 16px;
                height: auto;
                padding: 10px;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }
            .form-signin .form-control:focus {
                z-index: 2;
            }
            .form-signin input[type="text"] {
                margin-bottom: 8px;
                border-bottom-left-radius: 0;
                border-bottom-right-radius: 0;
            }
            .form-signin input[type="password"] {
                margin-bottom: 10px;
                border-top-left-radius: 0;
                border-top-right-radius: 0;
            }
            .sidebar-nav {
                padding: 9px 0;
            }

            @media (max-width: 980px) {
                /* Enable use of floated navbar text */
                .navbar-text.pull-right {
                    float: none;
                    padding-left: 5px;
                    padding-right: 5px;
                }
            }
        </style>
 <style type="text/css" media="print"> .noprint {visibility: hidden;} </style>
        <script type="text/javascript">



            /*   function printPage(){
             
             var tableData = document.getElementById('report').innerHTML;
             var data = tableData+'<style type="text/css" media="print"> .noprint {visibility: hidden;} </style><div style="padding-bottom: 6px; width:100%;font-size: 11px; font-family:  arial, helvetica; text-align: right; vertical-align: top; "></div><br/><button class="noprint" onclick="window.print()" style="float:left; -moz-border-radius: 4px; -webkit-border-radius: 4px; padding: 4px; ont-size: 12px; color: #333; font-size: 12px; padding: 4px; margin: 0; display: inline-block;	width: auto; background: #FFF !important; box-sizing: border-box; -webkit-box-align: center; border-color: #ccc #eee #eee #ccc; border-style: solid; url(../../../sns/clientWork/vw/mappingApp/icons_single.psd)  border-width: 1px;">Print the Report</button><button class="noprint" onclick="window.close();" style="float:right; -moz-border-radius: 4px; -webkit-border-radius: 4px; padding: 4px; ont-size: 12px; color: #333; font-size: 12px; padding: 4px; margin: 0; display: inline-block;	width: auto; background: #FFF !important; box-sizing: border-box; -webkit-box-align: center; border-color: #ccc #eee #eee #ccc; border-style: solid; url(../../../sns/clientWork/vw/mappingApp/icons_single.psd)  border-width: 1px;">Close Preview</button><br />';
             myWindow=window.open('','','width=800,height=600,scrollbars=yes');
             myWindow.innerWidth = screen.width;
             myWindow.innerHeight = screen.height;
             myWindow.screenX = 0;
             myWindow.screenY = 0;
             myWindow.document.write(data);
             myWindow.focus();
             };*/







        </script>
    </head>

    <body>


        <html:form action="receipt">

            <table align="center" border="0" style="position:relative;width:80%"><tr><td>
                        <img src="css/graphics/AMSLogo.png" height="30%" width="30%"> </td> <td style="position:relative"> </td></tr>
                <tr><td colspan="3"> <center>  <b>AMS TOURS AND TRAVELS</b> </br> 5-3-130/1,OPP,CENTRAL WARE HOUSE,MANNAGUDDA MAIN ROAD,MANGALORE - 575003<br/>
                            PH:0824 2450055,Mob:9742793024,9538105959<br/>
                            info@amstravels.com,www.amstravels.com</br><b><u>RECEIPT</u></b><br/><br/></center></td></tr><tr><td width="50%">
                        Receipt No : <bean:write name="receiptForm" property="receiptNoR" /></td>
                    <td><center>Receipt Date : <bean:write name="receiptForm" property="receiptDateR" /> </center></td></tr></table>
            <table align="center" border="0" style="position:relative;width:70%"><center><tr><td>
                            <center>Received with thanks from Sri / Smt <bean:write name="receiptForm" property="customerNameR" />
                                 <bean:write name="receiptForm" property="amountInWordsR" />
                                  ,as the hire charges by car / bus  bearing Reg No. <bean:write name="receiptForm" property="vehicleR" />  ,in
                                <bean:write name="receiptForm" property="paymentTypeR" /> payment by <bean:write name="receiptForm" property="paymentModeR" /> </center><br/><br/></td></tr></center><tr><td align="right">
                        For AMS Tours and Travels</td></tr><tr><td><b>Rs.<u> <bean:write name="receiptForm" property="amountR" /></u></b></td></tr></table>
<br/>
                        <button class="noprint" onclick="window.print()">Print the Report</button>
<br/>
<button class="noprint" onclick="window.close();">Close Preview</button><br/>
        </html:form>

    </body>
</html>