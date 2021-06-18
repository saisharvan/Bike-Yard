<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit customer details</title>
</head>
<body>
	<h1>Enter the details</h1>
	<br>
	<form:form modelAttribute="customer" action="updatecustomer" method="post">
		First name: <form:input path="firstname" /><br><br>
		Last name: <form:input path="lastname" /><br><br>
		Age : <form:input path="age" /><br><br>
		Gender: 
		Male<form:radiobutton path="gender" value="Male" />
		Female<form:radiobutton path="gender" value="Female" /><br><br>
		Email:<form:input path="email" /><br><br>
		Phone No:<select>
			<option>+91</option>
			<option>+63</option>
			<option>+01</option>
		</select>
		<form:input path="num" /><br><br>
		Address:<form:input path="address" /><br><br>
		
		<input type="submit" value="Edit Save" />
	</form:form>
</body>