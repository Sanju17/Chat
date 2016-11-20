<%@include file="../header.jsp" %>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">
            Welcome To LFA ChatRoom
        </a>
        <div class="nav navbar-right">
            <form class="form-inline" id="login-form" method="post">
                
                <c:if test="${param.error != null}">
                    <div class="form-group validation-summary-errors text-danger">
                        <ul>
                            <li>Invalid login attempt.</li>
                        </ul>
                    </div>   
                </c:if>
                <div class="form-group">
                    <input type="text" class="form-control input-sm" name="username" placeholder="Username">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control input-sm" name ="password" placeholder="Password">
                </div>
                <input type="hidden" name="type" value="login" />
                <button type="submit" class="btn btn-default input-sm">Login</button>
            </form>
        </div>
    </div>
</div>

<div class="container container-registration">   
    <div class="panel panel-default">
        <div class="panel-heading">Registration</div>
        <div class="panel-body">
            <form class="form-horizontal" id="registration_form"  method="post">
                <input name="type" type="hidden" value="register" />                    
                <c:if test="${requestScope.error != null}">
                    <div class="form-group validation-summary-errors text-danger">
                        <ul>
                            <li>${requestScope.error}</li>
                        </ul>
                    </div>   
                </c:if>
                
                <div class="form-group">
                    <label class="col-md-2 control-label" for="firstname">First Name: </label>
                    <div class="col-md-6">
                        <input class="form-control" id="firstname" name="firstname" type="text" <c:if test="${requestScope.firstname != null}"> value="${requestScope.firstname}" </c:if>  required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="lastname">Last Name: </label>
                        <div class="col-md-6">
                            <input class="form-control" id="lastname" name="lastname" type="text" <c:if test="${requestScope.lastname != null}"> value="${requestScope.lastname}" </c:if> required="required"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="username">User Name: </label>
                        <div class="col-md-6">
                            <input class="form-control" id="username" name="username" type="text" <c:if test="${requestScope.username != null}"> value="${requestScope.username}" </c:if>  required="required"/>
                            <span class="validation-summary-errors" id="username_error_message">asd</span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="password">Password </label>
                        <div class="col-md-6">
                            <input class="form-control" id="password" name="password" type="password" required="required" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label" for="confirmPassword">Confirm password</label>
                        <div class="col-md-6">
                            <input class="form-control" id="confirmPassword" name="confirmPassword" type="password" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-2 col-md-6">
                            <input type="submit" class="btn btn-success" value="Register" />
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    
<%@include file="../footer.jsp" %>