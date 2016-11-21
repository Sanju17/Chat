<%@include file="../header.jsp" %>
<%@include file="../user_navbar.jsp" %>
<div class="container">
    <form class="form form-inline" id="port_creation_form" method="post">
      <div class="form-group">
        <label for="exampleInputEmail2">Enter Port: </label>
        <input type="number" class="form-control" name="port_num" id="port_num" placeholder="eg: 9477" />
      </div>
        
        <input type="hidden" name="type" value="create" />
      <button type="submit" class="btn btn-default">Create</button>
    </form>
    <span class="validation-summary-errors" id="create_port_error"></span>
</div>

<%@include file="../footer.jsp" %>