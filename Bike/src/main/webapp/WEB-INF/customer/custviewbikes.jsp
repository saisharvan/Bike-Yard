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
   <table border="1">
     <thead>
       <tr>
        <th id="bn">Bike Number</th><th id="bname">Bike Name</th><th id="bcost">Bike Cost</th><th id="bc">Bike Color</th><th id="bd">Bike Description</th>
        <th id="avail">availability</th>
        <th id="action">Actions</th>
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
	      <td><a href="/Bike/book/${biked.id}"><button>Book</button></a></td>
	       </tr>
	   </c:forEach>
     </tbody>
   </table>
   
   <br><br>
   <a href="/Bike/hoome"><button>home</button></a>
  </body>
</html>