<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Person Page</title>

</head>
<body>

<%@include file="header.jsp" %>
<div class="container">
<h1>
    Add a Person
</h1>
 
<c:url var="addAction" value="/person/add" ></c:url>
 
<form:form action="${addAction}" modelAttribute="person">
<table>
    <c:if test="${!empty person.name}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
    <tr>
        <td>
            <form:label path="name">
                <spring:message text="Name"/>
            </form:label>
        </td>
        <td>
            <form:input path="name" />
        </td> 
    </tr>
    <tr>
        <td>
            <form:label path="country">
                <spring:message text="Country"/>
            </form:label>
        </td>
        <td>
            <form:input path="country" />
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty person.name}">
                <input type="submit"
                    value="<spring:message text="Edit Person"/>" />
            </c:if>
            <c:if test="${empty person.name}">
                <input type="submit"
                    value="<spring:message text="Add Person"/>" />
            </c:if>
                            <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Search
                </button>
            
        </td>
    </tr>
</table>  
</form:form>
<br>
<h3>Persons List</h3>
<c:if test="${!empty listPersons}">

 <table  class="table table-striped">
                            <thead>
    <tr>
        <th width="80">Person ID</th>
        <th width="120">Person Name</th>
        <th width="120">Person Country</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
     </thead>
    <c:forEach items="${listPersons}" var="person">
         <tr class="info">
            <td>${person.id}</td>
            <td>${person.name}</td>
            <td>${person.country}</td>
            <td><a href="<c:url value='/person/edit/${person.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/person/remove/${person.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</div>
<%@include file="footer.jsp" %>
</body>
</html>