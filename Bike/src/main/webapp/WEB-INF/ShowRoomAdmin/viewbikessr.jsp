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
        <th id="id">Bike Number</th><th id="id">Bike Name</th><th id="id">Bike Cost</th><th id="id">Bike Color</th><th id="id">Bike Description</th>
        <th id="id">availability</th>
        <th colspan="2" id="id">Actions id="id"</th>
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
	      <td><a href="editsr/${biked.id}">Edit</a></td>
	      <td><a href="deletebikesr/${biked.id}">Delete</a></td>
	       </tr>
	   </c:forEach>
     </tbody>
   </table>
   <a href="regsr">Add Bike</a> <br><br><br>
   <a href="srhome"><button>HOME</button></a> <br><br><br>
 
</body>
</html>