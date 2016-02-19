<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Nominations Page</title>

</head>
<body>

<%@include file="header.jsp" %>
<div class="container">
 
<h3>Persons List</h3>
<c:if test="${!empty nominationsViewList}">

 <table  class="table table-striped">
                            <thead>
    <tr>
        <th width="80">Nominee Name</th>
        <th width="120">Core Value</th>
        <th width="120">Comments</th>
		<th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
     </thead>
    <c:forEach items="${nominationsViewList}" var="nominationView">
         <tr class="info">
            <td>${nominationView.nomineePerson.name}</td>
            <td>${nominationView.coreValue}</td>
            <td>${nominationView.comments}</td>
			<td><a href="<c:url value='/nominate/edit/${nomination.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/nominate/remove/${nomination.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</div>
<%@include file="footer.jsp" %>
</body>
</html>