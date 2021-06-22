<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Bookeds</title>
</head>
<body style="colour:pink">
   <table border="1">
     <thead>
       <tr>
        <th>Booking Id</th><th>showadmin Id</th><th>Bike Id</th><th>Customer Id</th><th>Payment Id</th><th>Booking Status</th>
       </tr>
     </thead>
     <tbody>
        <c:forEach var="bk" items="${list}">
         <tr>
	      <td>${bk.id}</td>
	      <td>${bk.showadminId}</td>
	      <td>${bk.bikeId}</td>
	      <td>${bk.customerId}</td>
	      <td>${bk.paymentId}</td>
	      <td>${bk.status }</td>
	       </tr>
	   </c:forEach>
     </tbody>
   </table>
   <a href="home"><button>HOME</button></a> <br><br><br>
 
</body>
</html>