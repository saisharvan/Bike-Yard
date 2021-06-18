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
        <th colspan="2">Actions</th>
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
	      <td><a href="deletebikesr/${biked.id}">Delete<a/></td>
	       </tr>
	   </c:forEach>
     </tbody>
   </table>
   <a href="regsr">Add Bike</a> <br><br><br>
   <a href="srhome"><button>HOME</button></a> <br><br><br>
 
</body>
</html>