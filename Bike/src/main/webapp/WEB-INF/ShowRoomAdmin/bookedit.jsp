<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
	<form:form modelAttribute="book" action="updatebook" method="post">
	
<form:hidden path="id" />
		Booking Id:: ${book.id} <br><br>
		Bike Id:: ${book.bikeId}<br><br>
		Customer Id:: ${book.customerId}<br><br>
		Payment Id:: ${book.paymentId}<br><br>
		Booking Status: <form:input path="status" /><br><br>
		
		
		<input type="submit" value="Edit Save" />
	</form:form>
</body>