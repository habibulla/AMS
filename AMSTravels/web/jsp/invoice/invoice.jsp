
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

        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/theme.css" rel="stylesheet">
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

            function checkIntegerinString() {
                var form = document.forms[0];
                if (((form.customerName.value.toString()).match(".*\\d.*"))) {
                    alert("please enter character only .Nos not allowed");
                    form.customerName.focus();
                    form.customerName.value = '';
                    return false;
                }

            }
            function onOK()
            {
                var form = document.forms[0];
                if (form.customerName.value == "")
                {
                    alert("please enter name");
                    form.customerName.focus();
                    return false;
                }
                else if (form.address.value == "")
                {
                    alert("please enter address");
                    form.address.focus();
                    return false;
                }
                else if (form.mobileNo.value == "")
                {
                    alert("please enter mobile No");
                    form.mobileNo.focus();
                    return false;
                }
                else if (form.invoiceDate.value == "")
                {
                    alert("please enter Invoice date");
                    form.invoiceDate.focus();
                    return false;
                }
                else if (form.startDate.value == "")
                {
                    alert("please enter start date");
                    form.startDate.focus();
                    return false;
                }
                else if (form.endDate.value == "")
                {
                    alert("please enter end date");
                    form.endDate.focus();
                    return false;
                }
                else if (form.checkedVehicle.value == "")
                {
                    alert("please select vehicle");
                    form.checkedVehicle.focus();
                    return false;
                }
                else if (form.vehicleNo.value == "")
                {
                    alert("please enter vehicle no");
                    form.vehicleNo.focus();
                    return false;
                }
                else if (form.amount.value == "")
                {
                    alert("please enter amount");
                    form.amount.focus();
                    return false;
                }
                else if (isNaN(form.amount.value))
                {
                    alert("please enter valid amount");
                    form.amount.value = 0;
                    return false;
                }
                else if (form.startDate.value > form.endDate.value)
                {
                    alert("journey end date must be greater than journey start date");
                    return false;
                }

                var URL = "invoices.do?method=OK";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }

            function onOKOfCharge()
            {
                var form = document.forms[0];
                if (form.selectedOtherCharge.value == "")
                {
                    alert("please select other charges");
                    form.selectedOtherCharge.focus();
                    return false;
                }
                else if (form.otherChargeAmount.value == "")
                {
                    alert("please enter other charge amount");
                    form.otherChargeAmount.focus();
                    return false;
                }

                var URL = "invoices.do?method=OKOthercharge";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }

            /*
             var xmlHttp
             var xmlHttp
             var xmlHttp
             varfunction onOKOfCharge() {
             if (typeof XMLHttpRequest != "undefined") {
             xmlHttp = new XMLHttpRequest();
             }
             else if (window.ActiveXObject) {
             xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
             }
             if (xmlHttp == null) {
             alert("Browser does not support XMLHTTP Request")
             return;
             }
             var url = "invoices.do?method=OKOthercharge";
             //    url += "?count=" + str;
             xmlHttp.onreadystatechange = OK;
             xmlHttp.open("GET", url, true);
             xmlHttp.send(null);
             }
             
             function OK() {
             if (xmlHttp.readyState == 4 || xmlHttp.readyState == "complete") {
             document.getElementById("ok").innerHTML = xmlHttp.responseText
             }
             }
             */

            function onSave()
            {

                var form = document.forms[0];
                if (form.customerName.value == "")
                {
                    alert("please enter name");
                    form.customerName.focus();
                    return false;
                }
                else if (form.address.value == "")
                {
                    alert("please enter address");
                    form.address.focus();
                    return false;
                }
                else if (form.mobileNo.value == "")
                {
                    alert("please enter mobile No");
                    form.mobileNo.focus();
                    return false;
                }
                else if (form.invoiceDate.value == "")
                {
                    alert("please enter Invoice date");
                    form.invoiceDate.focus();
                    return false;
                }
                var URL = "invoices.do?method=saveInvoice";
                document.forms[0].action = URL;
                document.forms[0].submit();

            }

            function onPrint()
            {
                var URL = "invoices.do?method=printInvoice";

                window.open(URL, "Active",
                        'width=800, height=600, toolbar=no,location=no, resizable=yes,scrollbars=yes, directories=no,status=no, titlebar=no');
                //  var data = tableData + '<style type="text/css" media="print"> .noprint {visibility: hidden;} </style><div style="padding-bottom: 6px; width:100%;font-size: 11px; font-family:  arial, helvetica; text-align: right; vertical-align: top; "></div><br/><button class="noprint" onclick="window.print()" style="float:left; -moz-border-radius: 4px; -webkit-border-radius: 4px; padding: 4px; ont-size: 12px; color: #333; font-size: 12px; padding: 4px; margin: 0; display: inline-block;	width: auto; background: #FFF !important; box-sizing: border-box; -webkit-box-align: center; border-color: #ccc #eee #eee #ccc; border-style: solid; url(../../../sns/clientWork/vw/mappingApp/icons_single.psd)  border-width: 1px;">Print the Report</button><button class="noprint" onclick="window.close();" style="float:right; -moz-border-radius: 4px; -webkit-border-radius: 4px; padding: 4px; ont-size: 12px; color: #333; font-size: 12px; padding: 4px; margin: 0; display: inline-block;	width: auto; background: #FFF !important; box-sizing: border-box; -webkit-box-align: center; border-color: #ccc #eee #eee #ccc; border-style: solid; url(../../../sns/clientWork/vw/mappingApp/icons_single.psd)  border-width: 1px;">Close Preview</button><br />';

                //myWindow.document.write(data);

            }


            function fillAmount() {
                var form = document.forms[0];
                var kms = form.km.value;
                var rate = form.rate.value;
                var amount = rate * kms;
                form.amount.value = amount;
            }
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
             };
             */

            //Ajax Integration
            // The variable that makes Ajax possible!
            /* var xmlHttp;
             function onOKOfCharge() {
             if (typeof XMLHttpRequest != "undefined") {
             xmlHttp = new XMLHttpRequest();
             }
             else if (window.ActiveXObject) {
             xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
             }
             if (xmlHttp == null) {
             alert("Browser does not support XMLHTTP Request")
             return;
             }
             var url = "invoices.do?method=OKOthercharge";
             xmlHttp.open("GET", url, true);
             xmlHttp.onreadystatechange = processStateChange;
             xmlHttp.send();
             }
             
             function displayType() {
             if (xmlHttp.readyState == 4) {
             if (xmlHttp.status == 200) {
             var test = xmlHttp.responseXML;
             //  var var1 = test.getElementsByTagName("userType")[0].firstChild.data;
             var2 = test.getElementsByTagName("userType")[0].firstChild.data;
             
             //   document.forms[0].ok.value = var1;
             document.forms[0].grandTotal.value = var2;
             
             }
             }
             }
             
             function processStateChange() {
             if (req.readyState == 4) { // Complete
             if (req.status == 200) { // OK response
             document.forms[0].grandTotal.value = req.responseText;
             } else {
             alert("Problem: " + req.statusText);
             }
             }
             }
             */
        </script>
    </head>

    <body>
        <jsp:include page="/jsp/home/header.jsp" />

        <html:form action="invoices">
            <fieldset>


                <table style="position:relative; left:10%; width:80% ">
                    <tr>
                        <td>
                            Customer Name 
                        </td>
                        <td>
                            <html:text property="customerName" title="enter customer name" onchange="checkIntegerinString()" styleClass="input input-sm"/>
                        </td>

                        <td>Mobile No </td> <td>
                            <html:text property="mobileNo" title="enter mobile no" styleClass="input input-sm"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Email Id </td> 
                        <td>
                            <html:text property="emailID" title="enter email id" styleClass="input input-sm"/>
                        </td>
                        <html:hidden property="invoiceNo" />

                        <td> Invoice Date</td>    
                        <td>
                            <html:text property="invoiceDate"  styleId="invoice"  onfocus="popupCalender('invoice')" readonly="true" title="yyyy-mm-dd" styleClass="input input-sm"/>
                        </td>
                    </tr>
                    <tr>


                        <td>
                            Address  </td> 
                        <td>
                            <html:textarea property="address" title="enter address" styleClass="input input-sm"/>
                        </td>
                        <td>
                            Description </td>
                        <td><html:textarea property="description" title="enter description" styleClass="input input-sm"/></td>    

                    </tr>

                </table>



            </fieldset>

            <fieldset>
                <legend><h5>Running Charges </h5></legend>
                <table border="0" style="position:relative; left:10%; width:80% " >
                    <tr>
                        <td>From Date </td> <td>
                            <html:text property="startDate" styleId="date1" onfocus="popupCalender('date1')" title="yyyy-mm-dd" readonly="true"/>
                        </td>
                        <td>
                            To Date </td> <td>
                            <html:text property="endDate"  styleId="date2" onfocus="popupCalender('date2')" title="yyyy-mm-dd" readonly="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Class of Vehicle </td> <td>
                            <html:select  property="checkedVehicle"  style="width:73%">

                                <html:option value="">--Select--</html:option>

                                <html:optionsCollection property="vehicles"  value="id" label="label" />

                            </html:select>
                        </td>
                        <td>
                            Vehicle No </td> <td>
                            <html:text property="vehicleNo" title="enter vehicle no" />
                        </td>
                    </tr>
                    <tr>
                        <td>Kilo Meters </td> <td>
                            <html:text property="km"  onchange="fillAmount()" title="enter kilo meter" />
                        </td>
                        <td>
                            KM/rate </td> <td>
                            <html:text property="rate" onchange="fillAmount()" title="per km rate"/>
                        </td>
                    </tr>
                    <tr><td>
                            Amount </td> <td>
                            <html:text property="amount" />
                        </td>
                        <td>Place of visit </td> <td>
                            <html:textarea property="visitPlace" style="width:67.5% "> </html:textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:button  property="method" value="ok" onclick="onOK()"/>
                        </td>
                    </tr>
                </table>
            </fieldset>

            <br/>

            <div id="second">
                <table  class="table table-striped table-bordered table-condensed" style="font-size:12px;position: relative; left: 10%; width:80% ">
                    <tr>
                        <th>From Date</th>
                        <th>To Date</th>
                        <th>Vehicle</th>
                        <th>Vehicle No</th>
                        <th>Place of visit</th>
                        <th>KMs</th>
                        <th>KM/rate</th>
                        <th>amount(rs)</th>
                        <th>Delete</th>
                    </tr>
                    <logic:notEmpty name="invoiceForm" property="invoiceList">
                        <logic:iterate id="details" name="invoiceForm" property="invoiceList">
                            <tr>
                                <html:hidden name="details" property="rowID" />
                                <td>
                                    <bean:write name="details" property="fromDate" />
                                </td>
                                <td>
                                    <bean:write name="details" property="toDate" />
                                </td>
                                <td>
                                    <bean:write name="details" property="vehicle" />
                                </td>
                                <td>
                                    <bean:write name="details" property="vehicleNo" />
                                </td>
                                <td>
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
                                <td>
                                    <a onclick="if (!confirm('Are you sure?'))
                                                return false;"
                                       href="invoices.do?method=delete&vehicleNo=<bean:write name="details" property="vehicleNo"/>">delete</a>
                                </td>
                            </tr>

                        </logic:iterate>
                    </logic:notEmpty>


                </table>
            </div><br/>
            <div id="four">
                <fieldset>
                    <legend><h5>Additional Charges </h5></legend>
                    <table  style="position:relative; left:10%; width:80%" >
                        <tr>
                            <td>
                                Other Charge </td> <td>
                                <html:select  property="selectedOtherCharge" style="width:90%">

                                    <html:option value="">--Select--</html:option>

                                    <html:optionsCollection property="otherCharges"  value="id" label="label" />

                                </html:select>
                            </td>
                            <td>

                                Other Charge Amount </td> <td>
                                <html:text property="otherChargeAmount"/>
                            </td>
                        </tr> <tr>
                            <td><html:button value="OK" property="method" onclick="onOKOfCharge()"/>


                            </td>
                        </tr>
                    </table>
                </fieldset>
            </div>
            <br/>
            <div id="third">
                <table class="table table-striped table-bordered table-condensed" style="font-size:12px; position:relative; left:10%; width:80% " id="ok">
                    <tr>

                        <th>Other Charges </th>
                        <th>Amount(Rs)</th>
                        <th>Delete</th>
                    </tr>

                    <logic:notEmpty name="invoiceForm" property="chargeDetailsList">
                        <logic:iterate id="details" name="invoiceForm" property="chargeDetailsList">
                            <tr>

                                <html:hidden name="details" property="rowIDOtherCharge" />

                                <td>
                                    <bean:write name="details" property="otherCharges" />
                                </td>
                                <td>
                                    <bean:write name="details" property="otherChargeAmount" />
                                </td>
                                <td>
                                    <a onclick="if (!confirm('Are you sure?'))
                                                return false;"
                                       href="invoices.do?method=deleteOtherCharge&selectedOtherCharge=<bean:write name="details" property="rowIDOtherCharge"/>">delete</a>
                                </td>
                            </tr>

                        </logic:iterate>
                    </logic:notEmpty>
                </table>
            </div>
            <br/>

            <fieldset>
                <legend><h5></h5></legend>
                <table border="0" style="position:relative; left:47%; width:50% ">
                    <%--  <tr><td>
                              Service Tax </td><td>
                              <html:text property="serviceTax" onchange="return CheckDecimal(document.forms[0].serviceTax.value);"/>
                          </td>
                      </tr> --%>
                    <tr>
                        <td>
                            Grand Total </td><td>
                            <html:text property="grandTotal" />
                        </td>
                    </tr>
                    <tr>
                        <td>Amount in words </td><td>
                            <bean:write name="invoiceForm" property="amountInWords" />
                        </td>
                    </tr>
                    <tr>
                        <td> 
                            <html:button property="method" onclick="onSave()" value="save"/>
                            <logic:notEmpty name="printButton">
                                <html:button property="method" onclick="onPrint()" value="View Report"/>
                            </logic:notEmpty>


                        </td>
                    </tr>
                </table>
            </fieldset>

            <logic:notEmpty name="invoiceNoMessage">

                <div style="color: red" >

                    Saved Successfully with the Invoice No  <bean:write name="invoiceForm" property="maxInvoiceID"/> 
                    if you want to print click on print Report button
                </div>
            </logic:notEmpty>


        </html:form>

        <jsp:include page="/jsp/home/footer.jsp" />
    </body>
</html>