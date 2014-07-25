<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<!DOCTYPE html>
<meta http-equiv="Context-Type" content="text/html; charset=US-ASCII">

<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>AMS Tours and travels | Cabs</title>
        <meta name="keywords" content="taxi in mangalore,cabs in mangalore,rental car in mangalore ,car rentals" />
        <meta name="description" content="taxi servicesin mangalore, air port taxi in mangalore,taxi near coorg,rental cars in at subramanya,cabs" /> 
        <meta name="Revisit-After" content="7 days" />
        <meta property="og:image" content="http://www.amstravels.com/images/kafitech_logo.jpg"/>

        <link href="css/navbar-fixed-top.css" rel="stylesheet">
        <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="images/favicon.ico" rel="shrotcut icon" type="image/x-icon" />
        <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>

        <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery-1.6.4.min.js"></script>



        <script src="js/jquery.onebyone.min.js"></script>              
        <script src="js/jquery.touchwipe.min.js"></script> 
        <link href="css/jquery.onebyone.css" rel="stylesheet" type="text/css">
        <link href="css/example1.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="css/animate.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script type='text/javascript' src="calender/js/zapatec.js"></script>
        <script type="text/javascript" src="calender/js/calendar.js"></script>
        <script type="text/javascript" src="calender/js/calendar-en.js"></script>
        <link href="calender/css/zpcal.css" rel="stylesheet" type="text/css"/>
        <link href="calender/themes/aqua.css" rel="stylesheet" type="text/css"/>
        <link href="calender/themes/layouts/big.css" rel="stylesheet" type="text/css"/>



        <script type="text/javascript">

            <!--
                    function MM_preloadImages() { //v3.0
                var d = document;
                if (d.images) {
                    if (!d.MM_p)
                        d.MM_p = new Array();
                    var i, j = d.MM_p.length, a = MM_preloadImages.arguments;
                    for (i = 0; i < a.length; i++)
                        if (a[i].indexOf("#") != 0) {
                            d.MM_p[j] = new Image;
                            d.MM_p[j++].src = a[i];
                        }
                }
            }
            function MM_swapImgRestore() { //v3.0
                var i, x, a = document.MM_sr;
                for (i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++)
                    x.src = x.oSrc;
            }
            function MM_findObj(n, d) { //v4.01
                var p, i, x;
                if (!d)
                    d = document;
                if ((p = n.indexOf("?")) > 0 && parent.frames.length) {
                    d = parent.frames[n.substring(p + 1)].document;
                    n = n.substring(0, p);
                }
                if (!(x = d[n]) && d.all)
                    x = d.all[n];
                for (i = 0; !x && i < d.forms.length; i++)
                    x = d.forms[i][n];
                for (i = 0; !x && d.layers && i < d.layers.length; i++)
                    x = MM_findObj(n, d.layers[i].document);
                if (!x && d.getElementById)
                    x = d.getElementById(n);
                return x;
            }

            function MM_swapImage() { //v3.0
                var i, j = 0, x, a = MM_swapImage.arguments;
                document.MM_sr = new Array;
                for (i = 0; i < (a.length - 2); i += 3)
                    if ((x = MM_findObj(a[i])) != null) {
                        document.MM_sr[j++] = x;
                        if (!x.oSrc)
                            x.oSrc = x.src;
                        x.src = a[i + 2];
                    }
            }
            function MM_popupMsg(msg) { //v1.0
                confirm(msg);
            }
            //-->


            var jq171 = jQuery.noConflict();
            $(document).ready(function() {

                jq171('#banner2').oneByOne({
                    className: 'oneByOne1',
                    easeType: 'random',
                    slideShow: true
                });
            });
            var _gaq = _gaq || [];
            _gaq.push(['_setAccount', 'UA-33639264-1']);
            _gaq.push(['_setDomainName', 'amstravels.com']);
            _gaq.push(['_trackPageview']);
            (function() {
                var ga = document.createElement('script');
                ga.type = 'text/javascript';
                ga.async = true;
                ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                var s = document.getElementsByTagName('script')[0];
                s.parentNode.insertBefore(ga, s);
            })();
            function popupCalender(param)
            {
                var cal = new Zapatec.Calendar.setup({
                    inputField: param, // id of the input field
                    singleClick: true, // require two clicks to submit
                    ifFormat: "%d-%m-%Y %H-%M", // format of the input field
                    showsTime: true, // show time as well as date
                    button: "btn" // trigger button


                });
            }
            function paymentdet()
            {
                var form = document.forms[0];
                if (form.checkApproved.checked == true) {
                    document.getElementById('noninvoice').style.display = 'none';
                    return false;
                } else {
                    document.getElementById('noninvoice').style.display = '';
                    return false;
                }
            }

            function enableforlocal()
            {
                var form = document.forms[0];
                if (form.triptypesid.value == 1) {
                    document.getElementById('noninvoice').disabled = true;
                    return false;
                } else if (form.triptypesid.value == 2) {
                    document.getElementById('noninvoice').disabled = false;
                    return false;
                }
            }

            function paymentdet()
            {
                var form = document.forms[0];
                if (form.checkApproved.checked == true) {
                    document.getElementById('noninvoice').style.display = 'none';
                    return false;
                } else {
                    document.getElementById('noninvoice').style.display = '';
                    return false;
                }
            }

            function getLocationDetails() {
                if (form.selecteddirection.value == "")
                {
                    alert("please select other charges");
                    form.selecteddirection.focus();
                    return false;
                }
                var URL = "Airport.do?method=getLocationDetails";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }

            function getAmountDetails() {
                if (form.checkedVehicle.value == "")
                {
                    alert("please select vehicle type");
                    form.selecteddirection.focus();
                    return false;
                }
                var URL = "Airport.do?method=getAmountDetails";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function checkIntegerinString() {
                var form = document.forms[0];
                if (((form.customerName.value.toString()).match(".*\\d.*"))) {
                    
                }else{
                    alert("please enter character on .Nos not allowed");
                    form.customerName.focus();
                    form.customerName.value = '';
                    return false;
                }

            }


        </script>

        <style>
            .layer1 {
                margin: 1;
                padding: 30px;
                width: 100%;
                border: 1px;
                border-color: #255500;
            }

            .heading {
                margin: 1px;
                color: #fff;
                padding: 10px 20px;
                cursor: pointer;
                position: relative;
                background-color:#c30;
            }
            .content {
                padding: 10px 20px;
                background-color:#FDE8CD;
            }
            p { padding: 5px 0; }
        </style>
    </head>

    <body>
        <!-- Fixed navbar -->
        <div class="navbar navbar-default navbar-fixed-top" role="navigation" >
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div class="logo"><img style="height: 100px;width: 150px"  src="images/logo.png" alt="ams logo"></div>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">

                        <li><a href="gohome.do?method=displayHome">About us</a></li>
                        <li><a href="payment.do?method=displayGroups">Who we are</a></li>
                        <li><a href="addmember.do?method=displayGroups">Gallery</a></li>
                        <li><a href="Groupmemberdetails.do?method=displayGroupsdetails" >Contact Us</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><img src="images/fb.jpg" alt="facebook" class="img"></a></li>
                        <li><a href="#"><img src="images/twitter.jpg" alt="twitter" class="img"></a></li>
                        <li><a href="#"><img src="images/message.jpg" alt="message" class="message"></a></li>
                        <li><a href="logout.do?method=logout">Sign in</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>
        <br/><br/>
        <!-- Wrap all page content here -->
        <div id="wrap">

            <!-- Begin page content -->

            <div class="container">
                <html:form action="airport"  >


                    <div class="layer1" style="position:relative ;left:0%;width: 59%">
                        <p class="heading">* Fill trip details</p>
                        <div id="container">
                            <div class="navbar-collapse collapse" >
                                <ul class="nav navbar-nav">

                                    <li class="navbar-collapse">
                                        <a href="Airport.do?method=initialDisplay">  <img src="images/airport.jpg" alt="Local Trip" /></br>
                                            Airport Trip</a>
                                    </li>
                                    <li>
                                        <a href="local.do?method=initialDisplayforlocal">
                                            <img src="images/local.jpg" alt="Local Trip" /></br>
                                            Local Trip</a>
                                    </li>
                                    <li>
                                        <a href="OutofStation.do?method=initialDisplayforoutofstation">
                                            <img src="images/outofstation.jpg" alt="Local Trip" /></br>
                                            Out Of Station</a>
                                    </li>

                                </ul>

                            </div>
                        </div>  


                        <table class="table-condensed text-error">
                            <tr>
                                <td>Booking Date</td>
                                <td> <html:text property="fromdate" styleId="fromdate"  onfocus="popupCalender('fromdate')" title="dd-mm-yyyy hh mm a" styleClass="form-control"/>
                                </td>    
                                <td>Select direction</td>
                                <td>
                                    <html:select  property="selecteddirection"  style="width:100%" onchange="getLocationDetails">
                                        <html:option value="" >--Select--</html:option>
                                        <html:optionsCollection property="direction"  value="id" label="label" />
                                    </html:select>
                                </td>
                            </tr>
                            <tr>
                                <td>From Location: </td>
                                <td>
                                    <html:select  property="selectedFromlocation"  style="width:100%" >
                                        <html:option value="" >--Select--</html:option>
                                        <html:optionsCollection property="fromLocations"  value="id" label="label" />
                                    </html:select>
                                </td>
                                <td>To Location: </td>
                                <td>
                                    <html:select  property="selectedtolocation"  style="width:100%" name="bookingForm" >
                                        <html:option value="" >--Select--</html:option>
                                        <html:optionsCollection property="toLocations"  value="id" label="label" />
                                    </html:select>
                                </td>
                            </tr>
                            <tr>
                                <td>Picking time </td>
                                <td>
                                    <html:text property="pickuptime"  title="enter time in this format hh:mm:AM/PM" />
                                </td>
                            </tr>
                        </table>
                        <table class="table-condensed" style="font-size:12px;border: 1px;padding: 10px">
                            <tr>
                                <th>
                                    Vehicle Type
                                </th>
                                <th>
                                    Amount in Rs  </th> 
                                <th></th>


                            </tr>
                            <tr>
                                <td>
                                    <html:select  property="checkedVehicle"  style="width:100%" onchange="amountdeails()">
                                        <html:option value="" >--Select--</html:option>
                                        <html:optionsCollection property="vehicles"  value="id" label="label" />
                                    </html:select>
                                </td>
                                <td>
                                    <bean:write property="amount" name="bookingForm"/>
                                </td>
                                <td></td> <td>
                                    <html:image src="test.jpg" value="" alt="image" style="height:60px;width:60px;"/>
                                </td>
                            </tr>
                            <tr>
                                <td><html:button value="Continue >>" property="method" onclick="paymentdet()" title="Book your trip." styleClass="form-control btn-info"/></td>

                            </tr>
                        </table>
                    </div>
                </div>

                <div class="layer1" style="position:absolute ;left:60%;top:17%;width: 25%">
                    <p class="heading">Booking details</p>
                </div>

                <logic:notEmpty name="paymentdet">

                    <div class="layer1" style="position:relative ;left:57%;">
                        <p class="heading">* Enter Payment Details</p>  

                        <tr>
                            <td>
                                Total Amount to paid in advance
                            </td><td> <bean:write property="amount" name="bookingForm"/>

                            </td>
                        </tr> <tr>
                            <td>Payment method</td>
                            <td> <html:select  property="checkedVehicle"  style="width:100%" onchange="fillReceiptDetails()">

                                    <html:option value="">--Select--</html:option>

                                    <html:optionsCollection property="invoiceNumbers"  value="id" label="label" />

                                </html:select>
                            </td> </tr> <tr>
                            <td>
                                Bank Details
                            </td><td>
                                <html:text property="invoiceDate"  style="width:60%"  />
                            </td> </tr> <tr>
                            <td>
                                Invoice Date
                            </td><td>
                                <html:text property="invoiceDate"  style="width:60%"  />
                            </td> </tr>  <tr>
                            <td>
                                Referen ceno
                            </td><td>
                                <html:text property="invoiceDate"  style="width:60%"  />
                            </td> </tr> 
                        <tr>
                            <td>
                                Remarks
                            </td><td>
                                <html:text property="invoiceDate"  style="width:60%"  />
                            </td> </tr> 
                    </div>
                </logic:notEmpty>







            </div>

        </html:form>

    </div>
    <br/>
    <div class="container" style="background-repeat: repeat; background-image:url(images/bg.jpg);">
        <div id="who-we-are"></div>
        <div id="who-we-are-contant" style="font-family: verdana">Mangalore' No 1 travel agents ,we provide taxi's,tour packages, local and out of stations.feel free to cantact us :-) happy to serve </div>
    </div>
    <div id="footer-container" class="container">
        <div id="footer">
            <div id="testimonials-container">
                <div id="testimonials">
                    I enjoyed your services ,good support and guidance from AMS people thank you    
                    <br>
                    <br> Shankar - Mangalore 
                </div>
            </div>
            <div id="contact_info"></div><div id="contact_address"><i>AMS Tours & Travels <br>
                    Near central warehouse Mangalore<br>
                    Tel: , Fax: ,<br>
                    Email: info@amstravels.com,<br>
                    PO.BOX: 31796, Mangalore - karanataka <br>

                </i>
            </div>

        </div>
    </div>
</div>

<div class="navbar-fixed-bottom navbar-default">
    <div class="row">
        <p class="text-muted text-center">© amstravels tours and travels</p>
    </div>
</div>

<!--Add the following script at the bottom of the web page
<script type="text/javascript" src="https://mylivechat.com/chatinline.aspx?hccid=73571195"></script>
-->
</body>
</html>