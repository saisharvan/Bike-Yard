<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>View Bookeds</title>
</head>
<body style="colour:pink">
   <table>
   <caption>Super Admin Booking details</caption>
   
     <thead>
       <tr>
        <th id="booking">Booking Id</th><th id="showadmin">showadmin Id</th><th id="Bike">Bike Id</th><th id="customer">Customer Id</th><th id="status">Booking Status</th>
       </tr>
     </thead>
     <tbody>
        <c:forEach var="bk" items="${list}">
         <tr>
	      <td>${bk.id}</td>
	      <td>${bk.showadminId}</td>
	      <td>${bk.bikeId}</td>
	      <td>${bk.customerId}</td>
	      <td>${bk.status }</td>
	       </tr>
	   </c:forEach>
     </tbody>
   </table>
   <a href="home"><button>HOME</button></a> <br><br><br>
 
</body>
</html>