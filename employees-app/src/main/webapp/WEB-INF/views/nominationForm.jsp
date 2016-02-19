<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="header.jsp" %>

  
  <c:url var="createAction" value="/nominate/create" ></c:url>
 
<form:form action="${createAction}" modelAttribute="nominateView" >
 <div class="container">
      <form:hidden path="id" />
        <div class="form-group">
  <label for="sel1">Select list:</label>
  <form:select class="form-control" path="coreValue">
 <form:option value="" label="None" />
 <form:options items="${coreValuesMap}"/>
 </form:select>
</div>
<div class="form-group">
  <label for="sel1">Select list:</label>
  <form:select class="form-control" path="nomineePersonId">
 <form:option value="0" label="None" />
 <form:options items="${personsMap}" />
  </form:select>
</div>

    <div class="form-group">
  <label for="comment">Comment:</label>
  <textarea  class="form-control" rows="5" id="comments" name="comments" >${nominateView.comments}</textarea>

</div>
  <button type="submit" value="save" name="action"  class="btn btn-primary">Save</button>
<button type="submit" value="submit" name="action" class="btn btn-primary">Submit</button>
<button type="submit" value="cancel" name="action" class="btn btn-primary">Cancel</button>
</div>


   
</form:form>



<%@include file="footer.jsp" %>
</body>
</html>
