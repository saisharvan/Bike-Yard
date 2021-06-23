<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>View Bikes</title>
</head>
<body>
   <table>
    <caption>View Bikes</caption>
     <thead>
       <tr>
        <th id="bikenum">Bike Number</th><th id="bikename">Bike Name</th><th id="bikecost">Bike Cost</th><th id="bikecolour">Bike Color</th><th id="bikedis">Bike Description</th>
        <th id="availability">availability</th>
        <th colspan="2" id="action">Actions</th>
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
	      <td><a href="bedit/${biked.id}">Edit</a></td>
	      <td><a href="deletebike/${biked.id}">Delete</a></td>
	       </tr>
	   </c:forEach>
     </tbody>
   </table>
   <a href="reg">Add Bike</a> <br><br><br>
   <a href="home"><button>HOME</button></a>
</body>
</html>