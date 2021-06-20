<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Bikes</title>
</head>
<body>
   <table border="1">
     <thead>
       <tr>
        <th>Bike Number</th><th>Bike Name</th><th>Bike Cost</th><th>Bike Color</th><th>Bike Description</th>
        <th>availability</th>
        <th>Actions</th>
       </tr>
     </thead>
     <tbody>
        <c:forEach var="biked" items="${list}">
         <tr>
	      <td>${biked.id}</td>
	      <td>${biked.bikeName}</td>
	      <td>${biked.bikeCost}</td>
	      <td>${biked.bikeColor}</td>
	      <td>${biked.bikeDescription }</td>
	      <td>${biked.availability }</td>
	      <td><a href="book/${biked.id}"><button>Order</button></a></td>
	       </tr>
	   </c:forEach>
     </tbody>
   </table>
   
   <br><br>
   <a href="hoome"><button>home</button></a>
  </body>
</html>