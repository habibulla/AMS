
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<meta http-equiv="Context-Type" content="text/html; charset=US-ASCII">
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />

        <title>
            AMS Tours and Travels

        </title>
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

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">

        <script type="text/javascript">
            $("#code").keyup(function(event) {
                if (event.keyCode == 13) {
                    $("#login").click();
                }
            });

        </script>

    </head>
    <body>
        <!-- Fixed navbar -->
        <div class="navbar navbar-default navbar-fixed-top" role="navigation" style="background-color: white">
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
                        <li><a href="gohome.do?method=displayHome">Home</a></li>
                        <li><a href="payment.do?method=displayGroups">Who we are</a></li>
                        <li><a href="addmember.do?method=displayGroups">Gallery</a></li>
                        <li><a href="Groupmemberdetails.do?method=displayGroupsdetails" >Contact Us</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><img src="images/fb.jpg" alt="facebook" class="img"></a></li>
                        <li><a href="#"><img src="images/twitter.jpg" alt="twitter" class="img"></a></li>
                        <li><a href="#"><img src="images/message.jpg" alt="message" class="message"></a></li>
                        <!--  <li><a href="logout.do?method=logout">Sign in</a></li>  <!-- 
                   </ul>
               </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <br/><br/><br/><br/>
        <div class="container">  
            <html:form action="/logins" styleClass="form-signin">
                <h2 class="form-signin-heading">Sign in</h2>
                <input type="text" class="form-control" id="username" name="userName" placeholder="Username" required autofocus>
                <input type="password" class="form-control" id="code" name="password" placeholder="password" required>
                <div><button class="btn btn-lg btn-primary btn-block" type="submit" >LogIn</button></div>
                <br/>
                <font style="color:red">
                    <bean:write name="loginForm" property="message"/>
                </font>
                <br/><br/>

            </html:form>
        </div> 
        <div class="navbar-fixed-bottom navbar-default">
            <div class="row">
                <p class="text-muted text-center">© amstravels tours and travels</p>
            </div>
        </div>

    </body>
</html>