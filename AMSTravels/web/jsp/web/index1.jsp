<%-- 
    Document   : index
    Created on : 17 May, 2014, 11:11:41 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
﻿<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>AMS Tours and travels | Cabs</title>
        <meta name="keywords" content="taxi in mangalore,cabs in mangalore,rental car in mangalore ,car rentals" />
        <meta name="description" content="taxi servicesin mangalore, air port taxi in mangalore,taxi near coorg,rental cars in at subramanya,cabs" /> 
        <meta name="Revisit-After" content="7 days" />
        <meta property="og:image" content="http://www.amstravels.com/images/kafitech_logo.jpg"/>
        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />
        <link href="css/style.css" rel="stylesheet" type="text/css"> 
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/navbar-fixed-top.css" rel="stylesheet">
        <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/jquery-1.6.4.min.js"></script>
        <script src="js/jquery.onebyone.min.js"></script>              
        <script src="js/jquery.touchwipe.min.js"></script> 
        <link href="css/jquery.onebyone.css" rel="stylesheet" type="text/css">
        <link href="css/example1.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="css/animate.css">  

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

            $(document).ready(function() {


                $("li").hover(function() {
                    var itemwidth = $(this).width(); /* Getting the LI width */
                    $(this).prepend("<div class='hover'></div>"); /* Inserting a blank div into within li above the <a> tag*/
                    $(this).find("div").fadeIn('10000').css({'width': itemwidth}); /* Using the itemwidth for the div to display properly*/
                    $(this).find("ul").fadeIn('1000').slideDown('10000').css("display", "block");






                }, function() {
                    $(this).find("div").slideUp('1000').fadeOut('1000');/* sliding up and fading out the hover div */
                    $(this).find("div").remove();/* removing the <div> code from html at every mouseout event*/
                    $(this).find("ul").fadeOut('1000'); /* fading out the sub menu */

                });



                $(".search-input").focus(function() {
                    $(this).animate({width: '180px'}, 500); /* on focus, increasing the input width of search to left side*/
                });

                $(".search-input").focusout(function() {
                    $(this).animate({width: '117px'}, 500);  /* on focus, decreasing the input width of search to left side*/
                });



            });
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
        </script>
        <script type='text/javascript' src="calender/js/zapatec.js"></script>
        <script type="text/javascript" src="calender/js/calendar.js"></script>
        <script type="text/javascript" src="calender/js/calendar-en.js"></script>
        <link href="calender/css/zpcal.css" rel="stylesheet" type="text/css"/>
        <link href="calender/themes/aqua.css" rel="stylesheet" type="text/css"/>
        <link href="calender/themes/layouts/big.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <div class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <img src="images/logo.png" alt="ams logo" class="navbar-brand" style="height: 100px">
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="gohome.do?method=displayHome">Home</a></li>
                        <li><div id="fb"><img src="images/fb.jpg" alt="facebook" class="img"></div></li>
                        <li><div id="twitter"><img src="images/twitter.jpg" alt="twitter" class="img"></div></li>
                        <li><div id="message-icons"><img src="images/message.jpg" alt="message"></div></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Settings <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="changepassword.do?method=changePassword">Change Password</a></li>
                                <li><a href="usercreation.do?method=displayUsers">Create Users</a></li>
                                <li><a href="dataentry.do?method=displayData">Data Entry</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="../navbar/"></a></li>
                        <li><a href="#"  style="font-style: italic;"t class="text text-info"></a></li>
                        <li class="active"><a href="logout.do?method=logout">Logout</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>

        <div id="banner-container">
            <div id="banner">
                <div id="slide">
                    <div id="banner2">  		
                        <div class="oneByOne_item">
                            <span class="wp1">Solution for all</span>			
                            <span class="wp2">Small & medium vehicles services</span>	
                            <img src="images/monitor.png" class="img3" alt="">															
                            <img src="images/wordpress-128x128.png" class="img4" alt="">			
                        </div>


                        <div class="oneByOne_item">
                            <span class="wp1">Luxury</span>			
                            <span class="wp2">At low rate</span>	
                            <img src="images/dezire2.png" class="img3" alt="">															
                            <img src="images/wordpress-256x256.png" class="img4" alt="">	

                        </div>


                        <div class="oneByOne_item">
                            <span class="wp1">Comfortable</span>			
                            <span class="wp2">Staff's & support</span>															
                            <img src="images/book1.png" class="img1" alt="">					</div>


                        <div class="oneByOne_item">
                            <span class="wp1">Out of station</span>			
                            <span class="wp2">Let's go for long drive . . .</span>															
                            <img src="images/book2.png" class="wp2" alt="">			
                        </div>


                    </div> 

                </div>

            </div></div>




        <div id="contant-container"><div id="container-1"><div id="main-tittle"><span class="green-color"></span></div>
                    <html:form action="index">

                    <div class="panel-heading text-info" style="font-size: 20px;font-weight:bold;text-shadow: initial;">Book a Trip</div>
                    <table class="table-condensed text-error">
                        <tr>
                            <td>Name </td>
                            <td><html:text property="name" styleClass="form-control"/></td>
                        </tr>
                        <tr>
                            <td>Contact No: </td>
                            <td><html:text property="contactno" styleClass="form-control"/></td>
                        </tr>
                        <tr>
                            <td>E-mail: </td>
                            <td><html:text property="email" styleClass="form-control"/></td>
                        </tr>
                        <tr>
                            <td>Address: </td>
                            <td><html:textarea property="address" styleClass="form-control"/></td>
                        </tr>
                        <tr>
                            <td>From Date: </td>
                            <td> <html:text property="fromdate" styleId="fromdate"  onfocus="popupCalender('fromdate')" title="dd-mm-yyyy hh mm a" styleClass="form-control"/>
                            </td>    

                            <td>To Date: </td>
                            <td> <html:text property="todate" styleId="todate"  onfocus="popupCalender('todate')" title="dd-mm-yyyy" styleClass="form-control"/>
                            </td>    
                        </tr>
                        <tr>
                            <td>From Location: </td>
                            <td><html:text property="fromlocation" styleClass="form-control"/></td>
                            <td>To Location: </td>
                            <td><html:text property="tolocation" styleClass="form-control"/></td>
                        </tr>
                    </table>
                    <table class="table-condensed">
                        <tr>
                            <td></td>
                            <td></td>
                            <td><html:button value="Book" property="method" title="Book your trip." styleClass="form-control btn-info"/></td>

                        </tr>
                    </table>
                </html:form>
            </div>
        </div>
        <div id="contant-container-2"><div id="container-2">
                <div id="who-we-are"></div>
                <div id="who-we-are-contant">Mangalore' No 1 travel agents ,we provide taxi's,tour packages, local and out of stations.feel free to cantact us :-) happy to serve </div>

            </div></div>

        <div id="footer-container"><div id="footer"><div id="testimonials-container"><div id="testimonials">I enjoyed your services ,good support and guidance from AMS people thank you    
                        <br>
                        <br> Sharma - Mangalore </div><div id="copy-right">© amstravels tours and travels</div></div>
                <div id="contact_info"></div><div id="contact_address"><i>AMS Tours & Travels <br>
                        Near central warehouse Mangalore<br>
                        Tel: , Fax: ,<br>
                        Email: info@amstravels.com,<br>
                        PO.BOX: 31796, Mangalore - karanataka <br>

                    </i></div>

            </div></div>
        <!--Add the following script at the bottom of the web page-->
        <script type="text/javascript" src="https://mylivechat.com/chatinline.aspx?hccid=73571195"></script>

    </body>
</html>
