<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />

        <title>
            AMS Tours and Travels
        </title>

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
            function saveVehicleTypes()
            {
                if (document.forms[0].txtVehicleName.value.trim() == "")
                {
                    alert("Please enter vehicle name");
                    document.forms[0].txtVehicleName.focus();
                    return false;
                }

                var URL = "settings.do?method=saveVehicleTypes";
                document.forms[0].action = URL;
                document.forms[0].submit();

            }

            function saveOtherCharge()
            {
                if (document.forms[0].otherChargeType.value.trim() == "")
                {
                    alert("Please enter Charge details");
                    document.forms[0].txtVehicleName.focus();
                    return false;
                }

                var URL = "settings.do?method=saveOtherCharge";
                document.forms[0].action = URL;
                document.forms[0].submit();

            }
            function saveUserDetails()
            {
                if (document.forms[0].name.value.trim() === "")
                {
                    alert("Enter name");
                    document.forms[0].name.focus();
                    return false;
                } else if (document.forms[0].userName.value.trim() === "")
                {
                    alert("Enter User Name");
                    document.forms[0].userName.focus();
                    return false;
                } else if (document.forms[0].password.value.trim() === "")
                {
                    alert("Enter password");
                    document.forms[0].password.focus();
                    return false;
                } else if (document.forms[0].cpassWord.value.trim() === "")
                {
                    alert("Confirm password");
                    document.forms[0].cpassWord.focus();
                    return false;
                }

                var URL = "settings.do?method=saveUserDetails";
                document.forms[0].action = URL;
                document.forms[0].submit();

            }
            function updatePassword()
            {
                if (document.forms[0].currentPassword.value === "")
                {
                    alert("Please enter current passwword");
                    document.forms[0].currentPassword.focus();
                    return false;
                }
                if (document.forms[0].newPassword.value.trim() === "")
                {
                    alert("Please enter new password");
                    document.forms[0].newPassword.focus();
                    return false;
                }


                var URL = "settings.do?method=updatePassword";
                document.forms[0].action = URL;
                document.forms[0].submit();

            }
            
            function databackup()
            {
         
                var URL = "settings.do?method=databackup";
                document.forms[0].action = URL;
                document.forms[0].submit();

            }


            function validatepassword()
            {
                if (document.forms[0].newPassword.value.trim() === "")
                {
                    alert("confirm password");
                    document.forms[0].newPassword.focus();
                    return false;
                }

                var paswd = document.getElementById('passwd').value.trim();

                if (paswd != document.forms[0].newPassword.value)
                {
                    alert("password not matching");
                    document.getElementById('passwd').value = '';
                    document.forms[0].newPassword.value = '';
                    document.forms[0].newPassword.focus();
                    return false;
                }
            }
            function clearconfirmpassword() {
                document.forms[0].newPassword.value = '';
                return false;
            }

            function clearconfirmpassword1() {
                document.forms[0].cpassWord.value = '';
                return false;
            }

            function validatepassword1()
            {
                if (document.forms[0].password.value === "")
                {
                    alert("confirm password");
                    document.forms[0].password.focus();
                    return false;
                }



                if (document.forms[0].password.value !== document.forms[0].cpassWord.value)
                {
                    alert("password not matching");
                    document.forms[0].cpassWord.value = '';

                    return false;
                }
            }

            function checkForUserName() {
                if (document.forms[0].userName.value === "")
                {
                    alert("Please enter User Name");
                    document.forms[0].newPassword.focus();
                    return false;
                }

                var URL = "settings.do?method=checkForUserName";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }
            function checkForPassword() {
                var URL = "settings.do?method=checkForPassword";
                document.forms[0].action = URL;
                document.forms[0].submit();
            }

        </script>
    </head>
    <body>
        <jsp:include page="/jsp/home/header.jsp" />


        <html:form action="/settings" >

            <table border="0" style="position:relative; left:5%; width:90% ">
                <tr>
                    <td>
                        <fieldset>
                            <legend><h5>Vehicles details entry</h5></legend>
                            <table border="0" style="position:relative; left:10%; width:50% ">
                                <tr><td>

                                    </td></tr>
                                <tr>
                                    <td> Enter Vehicle Name</td>    
                                    <td>
                                        <html:text property="txtVehicleName"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td> Enter Remarks</td>   

                                    <td>
                                        <html:text property="txtRemarks"/>

                                    </td>

                                </tr>

                                <tr>
                                    <td>

                                        <html:button  property="method" value="Add" onclick="saveVehicleTypes()"/>
                                    </td>
                                    <td>

                                        <logic:notEmpty name="messagevehicletype">

                                            <div style="color: red" >

                                                 Vehicle type added...
                                            </div>
                                        </logic:notEmpty>  
                                    </td>
                                </tr>
                            </table>

                        </fieldset>
                    </td><td>
                        <fieldset>
                            <legend><h5>Other charges entry</h5></legend>
                            <table border="0" style="position:relative; left:10%; width:50% ">
                                <tr><td>
                                    </td></tr>
                                <tr>
                                    <td>Charge types</td>    
                                    <td>
                                        <html:text property="otherChargeType"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <html:button  property="method" value="Add" onclick="saveOtherCharge()"/>
                                    </td>
                                    <td>

                                        <logic:notEmpty name="messageOtherCharge">

                                            <div style="color: red" >

                                                 Other charge added...
                                            </div>
                                        </logic:notEmpty>  
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>

                </tr>   
                </br>

                <tr>
                    <td>

                        <fieldset>
                            <legend><h5>User creations</h5></legend>
                            <table border="0" style="position:relative; left:10%; width:50% ">
                                <tr><td>

                                    </td></tr>
                                <tr>
                                    <td>Name</td>    
                                    <td>
                                        <html:text property="name"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Mobile No</td>    
                                    <td>
                                        <html:text property="mobileNo"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>e-mail ID</td>    
                                    <td>
                                        <html:text property="emailID"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td> Enter address</td>   
                                    <td>
                                        <html:text property="address"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Remarks</td>    
                                    <td>
                                        <html:text property="remarks"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>User Name</td>    
                                    <td>
                                        <html:text property="userName" title="Use this user name to login to application in future" onchange="checkForUserName()"/>
                                        <bean:write name="settingsForm" property="message"/>
                                    </td>



                                </tr>
                                <tr>
                                    <td>Password</td>    
                                    <td>
                                        <html:password property="password" onchange="clearconfirmpassword1()"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Re-Type Password</td>    
                                    <td>
                                        <html:password property="cpassWord"  onchange="validatepassword1()"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Make administrator</td>    
                                    <td>
                                        <html:checkbox property="admin" title="If you check this user will get administrator permission"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <html:button  property="method" value="Register" onclick="saveUserDetails()"/>
                                    </td>  <td>

                                        <logic:notEmpty name="messageUsercreation">

                                            <div style="color: red" >

                                                user created Successfully ...
                                            </div>
                                        </logic:notEmpty>  
                                    </td>
                                </tr>
                            </table>

                        </fieldset>
                    </td><td>
                        <fieldset>
                            <legend><h5>Change password</h5></legend>

                            <table border="0" style="position:relative; left:10%; width:50% ">
                                <tr>
                                    <td>Current password</td>    
                                    <td>
                                        <html:password property="currentPassword" onchange="checkForPassword()"/>
                                        <bean:write name="settingsForm" property="messagePassword"/>
                                    </td>

                                </tr>
                                <tr>
                                    <td>Enter Password</td>    
                                    <td>
                                        <input type="password" id="passwd" value="" onchange="clearconfirmpassword()()"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Retype-Password</td>   
                                    <td>
                                        <html:password property="newPassword" onchange="validatepassword()"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td>

                                        <html:button  property="method" value="Save" onclick="updatePassword()"/>
                                    </td>
                                    <td>                
                                        <logic:notEmpty name="messageChangePassword">

                                            <div style="color: red" >

                                                New Password updated Successfully  ...
                                            </div>
                                        </logic:notEmpty>    
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr>
                
                 <tr>
                <td>
                        <fieldset>
                            <legend><h5>Data backup</h5></legend>

                            <table border="0" style="position:relative; left:10%; width:50% ">
                         
                                <tr>
                                    <td>

                                        <html:button  property="method" value="BackUp" onclick="databackup()"/>
                                    </td>
                                    <td>                
                                        <logic:notEmpty name="messageBackUp">

                                            <div style="color: red" >

                                                Data backup done Successfully  ...
                                            </div>
                                        </logic:notEmpty>    
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr>

            </table>
        </html:form>

        <jsp:include page="/jsp/home/footer.jsp" />
    </body>
</html>