<%@include file="../header.jsp" %>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">
            Welcome ,${sessionScope.firstName} ${sessionScope.firstName}
        </a>
        <a href="profile/logout" class="btn btn-danger pull-right" id="login-form">Log Out</a>
    </div>
</div>

<div class="container">
    <a href="/chatroom/create" class="btn btn-success margin10px">Create Chatroom</a>
    <a href="/chatroom/join" class="btn btn-success margin10px">Join Chatroom</a>
</div>

<%@include file="../footer.jsp" %>