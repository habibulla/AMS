<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<link href="css/navbar-fixed-top.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="images/favicon.ico" rel="shrotcut icon" type="image/x-icon" />

<div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <img src="css/graphics/AMSLogo.png" style="padding-right: 100px;height: 50px" title="AMS Tours and Travels" />
        </div>
        <div class="navbar-collapse collapse" >
            <ul class="nav navbar-nav">
           
                <li>
                    <a href="invoices.do?method=displayInvoice">Invoice</a>
                </li>
                <li>
                    <a href="receipt.do?method=displayReceipt">Receipt</a>
                </li>
                <li>
                    <a href="settings.do?method=displaySettings">Control Panel</a>
                </li>
                <li>
                    <a href="report.do?method=displayReport">Report</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="logout.do?method=logout">Logout</a></li>
            </ul>
        </div>

    </div>

</div>
