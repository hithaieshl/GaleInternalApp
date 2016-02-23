<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>login form</title>
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/reset.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/login.css">
	
    <script src="<%=request.getContextPath()%>/resources/js/prefixfree.min.js"></script>
  
  </head>
  <body>
	<div class="login" align="center">
		<header class="login-header"><span class="text">LOGIN</span><span class="loader"></span></header>
		<form:form class="login-form" id="loginForm" action="home" method="post" modelAttribute="loginBean">
			<form:label class="login-input" path="email"></form:label>
            <form:input class="login-input" placeholder="email" id="username" name="username" path="email" /><br>
            <form:label class="login-input" path="pass"></form:label>
            <form:password class="login-input" placeholder="password" id="password" name="password" path="pass" /><br>
            <form:button type="submit" class="login-btn"/>
		</form:form>
	</div>
  </body>
</html>