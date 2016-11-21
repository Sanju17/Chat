/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function (){
    $("#firstname_error_message").hide();
    $("#lastname_error_message").hide();
    $("#username_error_message").hide();
    $("#password_error_message").hide();
    $("#confirm_password_error_message").hide();
    
    
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