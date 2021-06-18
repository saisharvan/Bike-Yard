<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Details</title>
</head>
<body style="text-align:center">
<h1 style="text-align:center">Customer details are hear</h1><br><br>

<form:form modelAttribute="cus" action="custedit/${cus.id }">
	<h3>Customer ID =      ${cus.id }<br></h3> 
    <h3>First Name =	   ${cus.firstname}<br></h3>
    <h3>Last Name =   	   ${cus.lastname}<br></h3>
    <h3>Age = 		       ${cus.age}<br></h3>
    <h3>Gender =           ${cus.gender}<br></h3> 
    <h3>Email =            ${cus.email}<br></h3> 
    <h3>Phone Number =     ${cus.num}<br></h3>
    <h3>Address =          ${cus.address}<br></h3> 
    <input type="submit" value="Edit Data" />			
	</form:form>
</body>
</html>





