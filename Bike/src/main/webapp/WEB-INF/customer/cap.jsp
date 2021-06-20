<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Details</title>
</head>
<body style="text-align:center">
<h1 style="text-align:center">Please conform bikes details and do payment</h1><br><br>

<form:form modelAttribute="bik" action="/Bike/bookc/${bik.id}">
	  <h3>bikeName          :				 ${bik.bikeName}</h3>   
	  <h3>bikeCost       	:			 	 ${bik.bikeCost}</h3>
	  <h3>bikeColor         :				 ${bik.bikeColor}</h3>
	  <h3>bikeDescription   : 		         ${bik.bikeDescription }</h3>
	  <h3>availability	    :			     ${bik.availability }</h3>
	  
	  <button>Conform booking</button><br>
	</form:form>
	<br>
	<a href="/Bike/custview"><button>Back to Bikes</button></a>
</body>
</html>
