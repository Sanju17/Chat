<%-- 
    Document   : login.jsp
    Created on : Nov 20, 2016, 11:49:10 AM
    Author     : Owner
--%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
            
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <link rel="stylesheet" href="../css/bootstrapValidator.min.css" />
            
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" type="text/javascript"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
            
        <title>LFA Chat room</title>
            
        <style>
            
            body {
                margin-top: 50px;
            }
            .navbar-inverse {
                border-radius:0px;
            }
            #login-form {
                margin-top: 8px;
            }
                
            .container-registration {
                margin-top: 70px;
            }
                
            .validation-summary-errors{
                color: #ff0000;
            }
                
            .validation-summary-errors ul{
                list-style: none;
                margin-top: 8px;
            }
                
            .margin10px{
                margin:10px;
            }
                
            .form {
                margin-top: 60px;
            }
        </style>
            
            
        <script type="text/javascript">
            
            $(function (){
                $("#firstname_error_message").hide();
                $("#lastname_error_message").hide();
                $("#username_error_message").hide();
                $("#password_error_message").hide();
                $("#confirm_password_error_message").hide();
                $("#create_port_error").hide();
                
                var error_firstname = false;
                var error_lastname = false;
                var error_username = false;
                var error_password = false;
                var error_confirm_password = false;
                
                $("#firstname").focusout(function (){
                    check_firstname();
                });
                
                $("#lastname").focusout(function (){
                    check_lastname();
                });
                
                $("#username").focusout(function (){
                    check_username();
                });
                
                $("#password").focusout(function (){
                    check_password();
                });
                
                $("#confirmPassword").focusout(function (){
                    check_confirm_password();
                });
                
                $("#registration_form").submit(function(){
                    check_firstname();
                    check_lastname();
                    check_username();
                    check_password();
                    check_confirm_password();
                    
                    if(error_firstname === false && error_lastname === false && error_username === false && error_password === false && error_confirm_password === false){
                        return true;
                    }else {
                        return false;
                    }
                });
                
                $("#port_creation_form").submit(function (){
                    var stringLength = $("#port_num").val().length;
                    if(stringLength != 4){
                        $("#create_port_error").html("Port number should be of 4 digits.");
                        $("#create_port_error").show();
                        return false;
                    }else{
                        $("#create_port_error").hide();
                        return true;    
                    }
                });
                
                function check_firstname(){
                    error_firstname = false;
                }
                
                function check_lastname(){
                    error_lastname = false;
                }
                
                function check_username() {
                    error_username = false;
                    var stringLength = $("#username").val().length;
                    
                    if(stringLength < 6 || stringLength > 25){
                        $("#username_error_message").html("Username should be of 6 to 25 character long.");
                        $("#username_error_message").show();
                        error_username = true;
                        return;
                    }else{
                        $("#username_error_message").hide();
                    }
                    
                    var pattern = new RegExp("^([A-Za-z]|[0-9]|_)+$");
                    if(pattern.test($("#username").val())){
                        $("#username_error_message").hide();
                    }else {
                        $("#username_error_message").html("The username can only consist of alphabetical, number and underscore");
                        $("#username_error_message").show();
                        error_username = true;
                    }
                }
                
                function check_password(){
                    error_password = false;
                    var stringLength = $("#password").val().length;
                    
                    if(stringLength < 8){
                        $("#password_error_message").html("Password must of length 8");
                        $("#password_error_message").show();
                        error_password = true;
                        return;
                    }else{
                        $("#password_error_message").hide();
                    }
                    
                    var value = $("#password").val();
                    if(value === $("#username").val()){
                        $("#password_error_message").html("Password cannot be same as username");
                        $("#password_error_message").show();
                        error_password = true;
                        return;
                    }else{
                        $("#password_error_message").hide();
                    }
                }
                
                function check_confirm_password(){
                    error_confirm_password = false;
                    var value = $("#confirmPassword").val();
                    if(value !== $("#password").val()){
                        $("#confirm_password_error_message").html("Password mismatch.");
                        $("#confirm_password_error_message").show();
                        error_confirm_password = true;
                        return;
                    }else{
                        $("#confirm_password_error_message").hide();
                    }
                }
            });
        </script>
            
    </head>
    <body>