<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>View Bookeds</title>
</head>
<body>
   <table border="1">
     <thead>
       <tr>
        <th id="id">Booking Id</th><th id="id">Bike Id</th><th id="id">Customer Id</th><th id="id">Booking Status</th>
         <th id="id">Actions</th>
       </tr>
     </thead>
     <tbody>
        <c:forEach var="bk" items="${list}">
         <tr>
	      <td>${bk.id}</td>
	      <td>${bk.bikeId}</td>
	      <td>${bk.customerId}</td>
	      <td>${bk.status }</td>
	      <td><a href="editbook/${bk.id}">Edit</a></td>
	       </tr>
	   </c:forEach>
     </tbody>
   </table>
   <a href="srhome"><button>HOME</button></a> <br><br><br>
 
</body>
</html>