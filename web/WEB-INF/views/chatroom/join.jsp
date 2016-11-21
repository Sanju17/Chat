<%@include file="../header.jsp" %>
<%@include file="../user_navbar.jsp" %>

<div class="container">
    <form class="form" id="port_creation_form" method="post">
        <div class="form-group">
        <label for="ipaddress">Enter IP Address: </label>
        <input type="text" class="form-control" name="ipaddress" id="ipaddress" placeholder="eg: 192.169.10.107" />
      </div>
      <div class="form-group">
        <label for="port_num">Enter Port: </label>
        <input type="number" class="form-control" name="port_num" id="port_num" placeholder="eg: 9477" />
      </div>
        <input type="hidden" name="type" value="join" />
      <button type="submit" class="btn btn-default">Join</button>
    </form>
    <span class="validation-summary-errors" id="create_port_error"></span>
</div>

<%@include file="../footer.jsp" %>