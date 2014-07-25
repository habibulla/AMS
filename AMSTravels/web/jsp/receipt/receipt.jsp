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
        <%--<script type="text/javascript" src="script/allscripts.js"></script>--%>
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
                    inputField : param, // id of the input field
                    singleClick : true, // require two clicks to submit
                    ifFormat : "%Y-%m-%d", // format of the input field
                    showsTime : false, // show time as well as date
                    button : "button2" // trigger button
                });
            }
            function onSave()
            {
                
                
                var form=document.forms[0];
                
                if(form.customerName.value=="")
                {
                    alert("please enter Customer Name");
                    form.customerName.focus();
                    return false;
                }
                else  if(form.vehicle.value=="")
                {
                    alert("please enter vehicle");
                    form.vehicle.focus();
                    return false;
                }
                
                if(form.selectedPaymentMode.value=="")
                {
                    alert("please select Payment Mode");
                    form.selectedPaymentMode.focus();
                    return false;
                }
                if(form.selectedPaymentType.value=="")
                {
                    alert("please select  Payment Type");
                    form.selectedPaymentType.focus();
                    return false;
                }
                if(form.amount.value=="")
                {
                    alert("please enter amount");
                    form.amount.focus();
                    return false;
                }
             
                var URL="receipt.do?method=Save";
                
                form.action=URL;
                form.submit();
              
                
            }
            
            function fillReceiptDetails()
            {
                var form=document.forms[0];
                var URL="receipt.do?method=fillReceiptDetails";
                form.action=URL;
                form.submit();
            }
            
            function onAmountINRS()
            {
                var form=document.forms[0];
                var URL="receipt.do?method=showAmountINwords";
                form.action=URL;
                form.submit();
            }
            
            function check()
            {
                var form=document.forms[0];
                if(form.checkApproved.checked==true){
                    document.getElementById('noninvoice').style.display='none';
                    return false;
                }else{
                    document.getElementById('noninvoice').style.display='';
                    return false;
                }
                
            }
            
         
            
            
            
            function printPage(){
                var form=document.forms[0];
                var e =  document.getElementById('select1');
                var paymentMode = e.options[e.selectedIndex].text;
                var e1 =  document.getElementById('select2');
                var paymentType = e1.options[e1.selectedIndex].text;
               
       

                var tableData =  '<table align="center" border="0" style="position:relative;width:70%"><tr><td><img src="css/graphics/AMSLogo.png" height="30%" width="30%"> <b>AMS TOURS AND TRAVELS</b></td></tr><tr><td colspan="8"><center>5-3-130/1,OPP,CENTRAL WARE HOUSE,MANNAGUDDA MAIN ROAD,MANGALORE - 575003<br/>PH:0824 2450055,Mob:9742793024,9538105959<br/>info@amstravels.com,www.amstravels.com</br><b><u>RECEIPT</u></b></center><br/></td></tr><tr><td style="width:65%">Receipt No : ' +form.receiptNo.value+ ' </td><td>Receipt Date : ' +form.receiptDate.value+ '</td></tr></table><table align="center" border="0" style="position:relative;width:70%"><center><tr><td><center>Received with thanks from Sri / Smt ' +form.customerName.value+ ' rupees ' +test_value()+ ' only  as the hire charges by car / bus  bearing Reg No. ' +form.vehicle.value+ ' in ' +paymentType+ ' payment by '+paymentMode+'. </center><br/><br/></td></tr></center><tr><td align="right">For AMS Tours and Travels</td></tr><tr><td><b>Rs.<u> ' +form.amount.value+ '</u></b></td></tr></table>';
                var data = tableData+'<style type="text/css" media="print"> .noprint {visibility: hidden;} </style><div style="padding-bottom: 6px; width:100%;font-size: 11px; font-family:  arial, helvetica; text-align: right; vertical-align: top; "></div><br/><button class="noprint" onclick="window.print()" style="float:left; -moz-border-radius: 4px; -webkit-border-radius: 4px; padding: 4px; ont-size: 12px; color: #333; font-size: 12px; padding: 4px; margin: 0; display: inline-block;	width: auto; background: #FFF !important; box-sizing: border-box; -webkit-box-align: center; border-color: #ccc #eee #eee #ccc; border-style: solid;  border-width: 1px;">Print the Report</button><button class="noprint" onclick="window.close();" style="float:right; -moz-border-radius: 4px; -webkit-border-radius: 4px; padding: 4px; ont-size: 12px; color: #333; font-size: 12px; padding: 4px; margin: 0; display: inline-block;	width: auto; background: #FFF !important; box-sizing: border-box; -webkit-box-align: center; border-color: #ccc #eee #eee #ccc; border-style: solid; url(../../../sns/clientWork/vw/mappingApp/icons_single.psd)  border-width: 1px;">Close Preview</button><br />';
                myWindow=window.open('','','width=800,height=600,scrollbars=yes');
                myWindow.innerWidth = screen.width;
                myWindow.innerHeight = screen.height;
                myWindow.screenX = 0;
                myWindow.screenY = 0;
                myWindow.document.write(data);
                myWindow.focus();
            };
            function checkIntegerinString(){
                var form=document.forms[0];
                if(((form.customerName.value.toString()).match(".*\\d.*"))){
                    alert("please enter character only .Nos not allowed");
                    form.customerName.focus();
                    form.customerName.value='';
                    return false;
                }
                
            }
            
            function test_value() {
                  
                var form=document.forms[0];
             
                var junkVal=form.amount.value;
                junkVal = Math.floor(junkVal);
                var obStr = new String(junkVal);
                numReversed= obStr.split("");
                actnumber=numReversed.reverse();
    
                if(Number(junkVal) >=0){
                    //do nothing4
                }
                else{
                    alert('wrong Number cannot be converted');
                    return false;
                }
                if(Number(junkVal)==0){
                    return obStr+''+'Rupees Zero Only';
     
                }
                if(actnumber.length>9){
                    alert('Oops!!!! the Number is too big to covertes');
                    return false;
                }
                var iWords=["Zero", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"];
                var ePlace=['Ten', ' Eleven', ' Twelve', ' Thirteen', ' Fourteen', ' Fifteen', ' Sixteen', ' Seventeen', ' Eighteen', 'Nineteen'];
                var tensPlace=['dummy', ' Ten', ' Twenty', ' Thirty', ' Forty', ' Fifty', ' Sixty', ' Seventy', ' Eighty', ' Ninety' ];
                var iWordsLength=numReversed.length;
                var totalWords="";
                var inWords=new Array();
                var finalWord="";
                j=0;
                for(i=0; i<iWordsLength; i++){
                    switch(i)
                    {
                        case 0:
                            if(actnumber[i]==0 || actnumber[i+1]==1 ) {
                                inWords[j]='';
                            }
                            else {
                                inWords[j]=iWords[actnumber[i]];
                            }
                            inWords[j]=inWords[j];
                            break;
                        case 1:
                            tens_complication();
                            break;
                        case 2:
                            if(actnumber[i]==0) {
                                inWords[j]='';
                            }
                            else if(actnumber[i-1]!=0 && actnumber[i-2]!=0) {
                                inWords[j]=iWords[actnumber[i]]+' Hundred and';
                            }
                            else {
                                inWords[j]=iWords[actnumber[i]]+' Hundred';
                            }
                            break;
                        case 3:
                            if(actnumber[i]==0 || actnumber[i+1]==1) {
                                inWords[j]='';
                            }
                            else {
                                inWords[j]=iWords[actnumber[i]];
                            }
                            if(actnumber[i+1] != 0 || actnumber[i] > 0){
                                inWords[j]=inWords[j]+" Thousand";
                            }
                            break;
                        case 4:
                            tens_complication();
                            break;
                        case 5:
                            if(actnumber[i]==0 || actnumber[i+1]==1 ) {
                                inWords[j]='';
                            }
                            else {
                                inWords[j]=iWords[actnumber[i]];
                            }
                            inWords[j]=inWords[j]+" Lakh";
                            break;
                        case 6:
                            tens_complication();
                            break;
                        case 7:
                            if(actnumber[i]==0 || actnumber[i+1]==1 ){
                                inWords[j]='';
                            }
                            else {
                                inWords[j]=iWords[actnumber[i]];
                            }
                            inWords[j]=inWords[j]+" Crore";
                            break;
                        case 8:
                            tens_complication();
                            break;
                        default:
                            break;
                    }
                    j++;
                }
                function tens_complication() {
                    if(actnumber[i]==0) {
                        inWords[j]='';
                    }
                    else if(actnumber[i]==1) {
                        inWords[j]=ePlace[actnumber[i-1]];
                    }
                    else {
                        inWords[j]=tensPlace[actnumber[i]];
                    }
                }
                inWords.reverse();
                for(i=0; i<inWords.length; i++) {
                    finalWord+=inWords[i];
                }
                return finalWord;
            }
            function convert_amount_into_rupees_paisa(){
        
                var form=document.forms[0];
                var finalWord1 = test_value();
                var finalWord2 = "";
                var val = form.amount.value;
                var actual_val = form.amount.value;
                form.amount.value= val;
                if(val.indexOf('.')!=-1)
                {
                    val = val.substring(val.indexOf('.')+1,val.length);
                    if(val.length==0 || val.length=='00'){
                        finalWord2 = "zero paisa only";
                    }
                    else{
                        form.amount.value = val;
                        finalWord2 = test_value() + " paisa only";
                    }
                    return finalWord1 +" Rupees and "+finalWord2;
                }
                else{
                    //finalWord2 = " Zero paisa only";
                    return finalWord1 +" Rupees Only";
                }
                return actual_val;
            }
 
            function onPrint()
            {
                var URL="receipt.do?method=printReceipt";
               
                window.open(URL,"Active", 
                'width=800, height=600, toolbar=no,location=no, resizable=yes,scrollbars=yes, directories=no,status=no, titlebar=no');

            }
          

        </script>
    </head>

    <body>
        <jsp:include page="/jsp/home/header.jsp" />


        <html:form action="/receipt">

            <table border="0" align="center"   style="position:relative;width:80%">

                <tr>
                    <td>
                        Non Invoice
                        <input type="checkbox" name="checkApproved" onclick="check()" />
                    </td>
                </tr>
                <tr  id="noninvoice">

                    <logic:notEmpty name="nonInvoice">



                        <td>

                            Invoice No
                        </td><td>
                            <html:select  property="invoiceNo"  style="width:100%" onchange="fillReceiptDetails()">

                                <html:option value="">--Select--</html:option>

                                <html:optionsCollection property="invoiceNumbers"  value="id" label="label" />

                            </html:select>
                        </td>
                        <td>
                            Invoice Date
                        </td><td>
                            <html:text property="invoiceDate"  style="width:60%"  />


                        </td>

                    </logic:notEmpty>


                </tr></table><br/>
            <table border="0" align="center" style="position:relative;width:80%">
                <tr>

                    <td> Receipt No</td><td>
                        <html:text  property="receiptNo" readonly="true" style="width:60%"/>
                    </td>
                    <td>
                        Receipt Date </td> <td>
                        <html:text  property="receiptDate" readonly="true" style="width:60%"/>
                    </td>
                </tr>

                <tr>
                    <td>Customer Name</td><td>
                        <html:text property="customerName" style="width:60%" title="enter Customer Name" onchange="checkIntegerinString()"/>
                    </td>

                </tr>
                <tr>
                    <td>
                        Payment Mode</td><td>
                        <html:select  property="selectedPaymentMode" styleId="select1" style="width:60%" >

                            <html:option value="">--Select--</html:option>

                            <html:optionsCollection property="paymentMode"  value="id" label="label" />

                        </html:select>

                    </td>
                    <td>
                        <br/>
                        Payment Type</td><td>
                        <html:select  property="selectedPaymentType" styleId="select2" style="width:60%" >

                            <html:option value="">--Select--</html:option>

                            <html:optionsCollection property="paymentType"  value="id" label="label" />

                        </html:select>


                    </td>
                </tr>
                <tr>
                    <td>Vehicle</td><td>
                        <html:textarea property="vehicle"  title="enter vehicle name" style="width:60%" />
                    </td>
                    <td>
                        <br/>
                        Remarks</td><td>
                        <html:textarea property="remarks"   title="enter Remarks" style="width:60%" />
                    </td>
                </tr>
                <tr>

                    <td><br/>Amount in Rs</td><td>
                        <html:text property="amount"   style="width:60%" title="enter Amount" onchange="test_value()"/>
                        <html:hidden property="amountWords"  />
                    </td>





                </tr>
                <tr>
                    <td>
                        <html:button value="Save" property="method"  onclick="onSave()"/>
                         <logic:notEmpty name="printButton">
                                <html:button property="method" onclick="onPrint()" value="View Report"/>
                            </logic:notEmpty>
                    </td>
                </tr>
            </table>






     


        <div align="center" id="report" style="display:none">

            <table align="center" border="0" style="position:relative;  width:60%">

                <tr>  <td><img src="css/graphics/AMSLogo.png" height="50%" width="70%"></> <td><h2><center>AMS TOURS AND TRAVELS</center></h2></td></tr><tr>


                    <td colspan="8"><center>5-3-130/1,OPP,CENTRAL WARE HOUSE,
                    MANNAGUDDA MAIN ROAD,
                    MANGALORE - 575003<br/>
                    PH:0824 2450055,
                    Mob:9742793024,9538105959<br/>
                    info@amstravels.com,
                    www.amstravels.com</br>
                    <b><u>RECEIPT</u></b>
                </center><br/>
                </td>

                </tr>
                <tr>
                    <td>Receipt No :
                        <bean:write property="receiptNo"  name="receiptForm" /></td>
                    <td></td> 
                    <td>Receipt Date
                        <bean:write property="receiptDate"  name="receiptForm" />

                    </td>
                    <td>Receipt Date


                        <span id="amountWords"><bean:write property="amountWords"  name="receiptForm" /></span>

                    </td>
                </tr>

                <tr>
                    <td>

                        Received with thanks from Sri / Smt <bean:write property="customerName"  name="receiptForm" /> 
                        <bean:write property="amountWords"  name="receiptForm" />  as the Hire Charges by 
                        Car / Bus  bearing Reg No. <bean:write property="vehicle"  name="receiptForm" /> in <bean:write property="receiptPaymentType"  name="receiptForm" /> payment 
                        by <bean:write property="receiptPaymentMode"  name="receiptForm" />
                    </td>

                </tr>
                <tr>

                    <td align="right">
                        </br>
                        For AMS Tours and Travels </br>

                        </br>
                    </td>
                </tr>
                <tr>

                    <td align="right">
                        </br>
                        Sign </br>

                        </br>
                    </td>
                </tr>
                <tr><td>

                        RS.<bean:write property="amount"  name="receiptForm" />
                    </td></tr>
            </table>
        </div>
        <div align="center" id="report11" style="display:none">

            <table align="center" border="0" style="position:relative; left:10%; width:60%">

                <center> <h5 align="center">RECEIPT</h5>
                    <h5><u>AMS TOURS AND TRAVELS</u></h5>
                    “simanivas” santhoshnagar ,munnur PO .Permannur Mangalore 574 017<br/>
                    PH:0824 2461991<br/>
                    Mob:9742793024,8050287215<br/>
                    info@amstravels.com<br/>
                    amstours@yahoo.com<br/>
                    www.amstravels.com</center><br/>


                <tr>
                    <td>Receipt No </td> <td>
                        <bean:write property="rno"  name="receiptForm" />
                    </td>
                    <td>Receipt Date </td> <td>
                        <bean:write property="rdate"  name="receiptForm" />
                    </td>
                </tr>
                <tr>
                    <td>Invoice No </td> <td>
                        <bean:write property="ino"  name="receiptForm" />
                    </td>
                    <td>Invoice Date </td> <td>
                        <bean:write property="idate"  name="receiptForm" />
                    </td>
                </tr>
                <tr>
                    <td>Name </td> <td>
                        <bean:write property="cname"  name="receiptForm" />
                    </td>

                </tr>
                <tr>
                    <td>Vehicle Details </td> <td>
                        <bean:write property="vehicleDetail"  name="receiptForm" />
                    </td>

                </tr>
                <tr>
                    <td>Remarks </td> <td>
                        <bean:write property="rremarks"  name="receiptForm" />
                    </td>

                </tr>
                <tr>

                    <td>Amount In Rs</td> <td>
                        <bean:write property="ramount"  name="receiptForm" />
                    </td>
                    <td>Amount In Words </td> <td>
                        <bean:write property="amountWords"  name="receiptForm" />
                    </td>
                </tr>




            </table>


        </div>


    </html:form>

    <jsp:include page="/jsp/home/footer.jsp" />
</body>
</html>