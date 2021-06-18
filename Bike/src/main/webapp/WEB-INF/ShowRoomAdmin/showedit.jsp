<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit showroom details</title>
</head>
<body>
	<h1>Enter the details</h1>
	<br>
	<form:form modelAttribute="ShowRoomAdmin" action="updateshowroom" method="post">
		showRoomId: <form:input path="showRoomId" /><br><br>
		userName: <form:input path="userName" /><br><br>
		showRoomName: <form:input path="showRoomName" /><br><br>
		email: <form:input path="email" /><br><br>
		showRoomAddress: <form:input path="showRoomAddress" /><br><br>
		showRoomLocation: <form:input path="showRoomLocation" /><br><br>
		
		
		<input type="submit" value="Edit Save" />
	</form:form>
</body>