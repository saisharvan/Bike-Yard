<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Showroom Admin Registration</title>

</head>
<body>
	<h1>Enter the details</h1>
	<br>
	<form:form method="post" action="showsave" modelAttribute="ShowRoomAdmin">
		Admin name: <form:input path="userName" />		
		<br><br>
		showRoomName: <form:input path="showRoomName" />
		<br><br>
		Email:<form:input path="email" />
		<br><br>
		Password: <form:input path="password" />
		<br><br>
		Address:<form:input path="showRoomAddress" />
		<br><br>
		Location: <form:input path="showRoomLocation" />
		<br><br>
		<input type="submit" value="Admin Register" />
	</form:form>
</body>