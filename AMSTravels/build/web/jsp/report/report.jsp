<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<meta http-equiv="Context-Type" content="text/html; charset=US-ASCII">

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

        <script type="text/javascript">
            function popupCalender(param)
            {
                var cal = new Zapatec.Calendar.setup({
                    inputField: param, // id of the input field
                    singleClick: true, // require two clicks to submit
                    ifFormat: "%Y-%m-%d", // format of the input field
                    showsTime: false, // show time as well as date
                    button: "button2" // trigger button
                });
            }

            function onOK()
            {
                var form = document.forms[0];
                if (form.fromeDate.value > form.toDate.value) {
                    alert("!!Oops From Date should be less than to date...");
                }
                
                var URL = "report.do?method=searchreportdetails";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            
            function changeReporttype()
            {
                var URL = "report.do?method=clearList";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            
            
            function onViewReport(documentNo)
            {

           
            var link="report.do?method=viewReport&documentNo="+documentNo;

            window.open(link,"Active", 
            'width=1000, height=700, toolbar=no,location=no, resizable=yes,scrollbars=yes, directories=no,status=no, titlebar=no');
            
    }  
        </script>
    </head>

    <body>

        <jsp:include page="/jsp/home/header.jsp" />


        <html:form action="report">
            <html:hidden property="documentNo"/>




            <div align="center" style="display:none" >
                <h3><u>AMS TOURS AND TRAVELS</u></h3><br/>
                <h5>“simanivas” santhoshnagar ,munnur PO .Permannur Mangalore 574 017</h5><br/>
                <h5>PH:0824 2461991</h5><br/>
                <h5>Mob:9742793024,8050287215</h5><br/>
                <h5>info@amstravels.com</h5><br/>
                <h5>amstours@yahoo.com</h5><br/>
                <h5>www.amstravels.com</h5>

            </div>

            <table border="0" style="position:relative; left:10%; width:80% ">
                <tr>

                    <td>Report Type</td>    

                    <td>
                        <html:select  property="selectedReport"  style="width:40%" onchange="changeReporttype()">

                          

                            <html:optionsCollection property="reportType"  value="id" label="label" />

                        </html:select>

                    </td> 


                </tr>
                <tr>

                    <td> From Date</td>    
                    <td>
                        <html:text property="fromeDate"  styleId="date1"  onfocus="popupCalender('date1')" readonly="true" title="yyyy-mm-dd"/>
                    </td>

                    <td> To Date</td>    
                    <td>
                        <html:text property="toDate"  styleId="date2"  onfocus="popupCalender('date2')" readonly="true" title="yyyy-mm-dd"/>
                    </td>

                </tr>
                <tr>
                    <td>
                        <html:button  property="method" value="ok" onclick="onOK()"/>
                    </td>
                </tr>

            </table>

                    <br>
                    <br>
                    <br>

                    
             <table  class="table table-striped table-bordered table-condensed" style="font-size:12px;position: relative; left: 10%; width:80% ">

                <tr>

                    <th>Document No</th>
                    <th>Document Date</th>
                    <th>Customer Name</th>
                    <th>Description</th>
                    <th>amount(rs)</th>

                    <th>View Report</th>
                    <th>Delete</th>

                </tr>  
                <logic:notEmpty name="reportForm" property="reportDetails">
                    <logic:iterate id="details" name="reportForm" property="reportDetails">
                        <tr>


                            <td style="width:15%">
                                <bean:write name="details" property="documentNo" />
                            </td>
                            <td style="width:15%">
                                <bean:write name="details" property="documentDate" />
                            </td>
                            <td>
                                <bean:write name="details" property="customerName" />
                            </td>
                            <td>
                                <bean:write name="details" property="description" />
                            </td>
                            <td style="width:15%">
                                <bean:write name="details" property="amount" />
                            </td>
                             <td>
                                <a
                                   onclick="onViewReport(${details.documentNo})">View</a>
                            </td>
                            <td>
                                <a
                                    onclick="if(!confirm('Are you sure?'))return false;"  href="report.do?method=deleterow&documentNo=<bean:write name="details" property="documentNo"/>">Delete</a>
                            </td>

                        </tr>

                    </logic:iterate>
                </logic:notEmpty>
            </table>

        </html:form>

        <jsp:include page="/jsp/home/footer.jsp" />
    </body>
</html>