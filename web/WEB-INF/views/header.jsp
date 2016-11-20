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
        <script src="../js/bootstrapValidator.min.js" type="text/javascript"></script>
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
        </style>
            
        <script type="text/javascript">
            $(function (){
                $("#username_error_message").hide();
                var error_username = false;
                $("#username").focusout(function (){
                    check_username();
                });
                
                function check_username() {
                    var stringLength = $("#username").val().length;
                    
                    if(stringLength < 6 || stringLength > 25){
                        $("#username_error_message").html("Username should be of 6 to 25 character long.");
                        $("#username_error_message").show();
                        error_username = true;
                        return;
                    }else{
                        $("#username_error_message").hide();
                    }
                    
                    var pattern = new RegExp("/^[a-zA-Z0-9_]+$/");
                    if(pattern.test($("#username").val())){
                        $("#username_error_message").hide();
                    }else {
                        $("#username_error_message").html("The username can only consist of alphabetical, number and underscore");
                        $("#username_error_message").show();
                        error_username = true;
                    }
                }
            });
        </script>
    
    </head>
    <body>