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
<h1 style="text-align:center">Your Booked bikes details Are Hear</h1><br><br>

<form:form modelAttribute="bik">
	  <h3>bikeName : 				 ${bik.bikeName}<br></h3> <br>   
	  <h3>bikeCost : 				 ${bik.bikeCost}<br></h3><br>
	  <h3>bikeColor : 			     ${bik.bikeColor}<br></h3><br>
	  <h3>bikeDescription :		     ${bik.bikeDescription }<br></h3><br>
	  <h3>availability :			 ${bik.availability }<br></h3><br>
	</form:form>
	
	<a href="/Bike/hoome"><button>Back to Home</button></a>
</body>
</html>





