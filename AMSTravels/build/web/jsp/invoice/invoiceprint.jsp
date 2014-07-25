
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
      

        <html:form action="invoices">



            <div align="center" id="report" >

                <table align="center" border="1" cellspacing="0" style="position:relative;  width:75%;">

                    <tr style="height: 20%" >  <td style="width:40%"><img src="css/graphics/AMSLogo.png" height="100%" width="100%"></td> <td colspan="6"  ><b><center>AMS TOURS AND TRAVELS</center></b></td></tr>
                </table>
                
                <table align="center" border="1" cellspacing="0" style="position:relative;  width:75%;">
                    <tr><td colspan="8"><center>5-3-130/1,OPP,CENTRAL WARE HOUSE,
                                MANNAGUDDA MAIN ROAD,
                                MANGALORE - 575003<br/>
                                PH:0824 2450055,
                                Mob:9742793024,9538105959<br/>
                                info@amstravels.com,
                                www.amstravels.com</br>
                                <b><u>INVOICE</u></b>
                            </center><br/>
                        </td></tr>
                    <tr>
                        <td colspan="2">
                            Customer Name 
                        </td>
                        <td colspan="6">
                            <bean:write name="invoiceForm" property="customerNameR"/>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            Address
                        </td>
                        <td colspan="6">
                            <bean:write name="invoiceForm" property="addressR"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            Mobile No
                        </td>
                        <td colspan="6">
                            <bean:write name="invoiceForm" property="mobileNoR"/>
                        </td>


                    </tr>
                    <tr>
                        <td colspan="2">
                            Description
                        </td>
                        <td colspan="6">
                            <bean:write name="invoiceForm" property="descriptionR"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            Invoice No
                        </td>
                        <td colspan="1">
                            <bean:write name="invoiceForm" property="invoiceNoR"/>
                        </td>
                        <td colspan="2">
                            Invoice Date
                        </td>
                        <td colspan="3">
                            <bean:write name="invoiceForm" property="invoiceDateR"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="8"><b>Running Charges</b></td>
                    </tr>
                   
                    <tr>

                        <td style="width:15%">From Date</td>
                        <td style="width:15%">To Date</td>
                        <td>Vehicle Type</td>
                        <td>Vehicle No</td>
                        <td style="width:15%">Place of visit</td>
                        <td>Kms</td>
                        <td>Rate</td>
                        <td>Amount(Rs)</td>



                    </tr>

                   
                    <logic:notEmpty name="invoiceForm" property="invoiceListR">
                        <logic:iterate id="details" name="invoiceForm" property="invoiceListR">
                            <tr>

                                <html:hidden name="details" property="rowID" />

                                <td style="width:15%">
                                    <bean:write name="details" property="fromDate" />
                                </td>
                                <td style="width:15%">
                                    <bean:write name="details" property="toDate" />
                                </td>
                                <td>
                                    <bean:write name="details" property="vehicle" />
                                </td>
                                <td>
                                    <bean:write name="details" property="vehicleNo" />
                                </td>
                                <td style="width:15%">
                                    <bean:write name="details" property="visitPlace" />
                                </td>

                                <td>
                                    <bean:write name="details" property="km" />
                                </td>
                                <td>
                                    <bean:write name="details" property="rate" />
                                </td>
                                <td>
                                    <bean:write name="details" property="amount" />
                                </td>


                            </tr>

                        </logic:iterate>
                    </logic:notEmpty>
                            

                    <tr>
                        <td colspan="8"><b>Additional Charges</b></td>
                    </tr>
                    <tr>

                        <td colspan="4">Other Charges </td>
                        <td colspan="4">Amount(Rs)</td>

                    </tr>

                    <logic:notEmpty name="invoiceForm" property="chargeDetailsListR">
                        <logic:iterate id="details" name="invoiceForm" property="chargeDetailsListR">
                            <tr>

                                <html:hidden name="details" property="rowIDOtherCharge" />

                                <td colspan="4">
                                    <bean:write name="details" property="otherCharges" />
                                </td>
                                <td colspan="4">
                                    <bean:write name="details" property="otherChargeAmount" />
                                </td>

                            </tr>

                        </logic:iterate>
                    </logic:notEmpty>
 
                    <tr><td colspan="1">
                            Grand Total
                        </td>
                        <td colspan="1">
                            <bean:write name="invoiceForm" property="grandTotalR" />
                        </td>
                        <td colspan="1">
                            Amount In words
                        </td>
                        <td colspan="5">
                            <bean:write name="invoiceForm" property="amountInWordsR" />
                        </td></tr>
                    

                </table>   
               
                <br/><br/>
                <table align="center" border="0" cellspacing="0" style="position:relative;  width:75%;">
                    <tr><td align="right">For AMS Tours and Travels</td></tr>                      </table>
                <br/>
                <table align="center" border="0" cellspacing="0" style="position:relative;  width:75%;">
                    <tr><td align="center">Thank you for doing business with AMS tours and travels</td></tr>                      </table>




            </div>
                        
<button class="noprint" onclick="window.print()">Print the Report</button>
<br/>
<button class="noprint" onclick="window.close();">Close Preview</button><br/>

        </html:form>
       
    </body>
</html>