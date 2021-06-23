<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Bookeds</title>
</head>
<body>
   <table border="1">
     <thead>
       <tr>
        <th>Booking Id</th><th>Bike Id</th><th>showroom admin Id</th><th>Booking Status</th>
       </tr>
     </thead>
     <tbody>
        <c:forEach var="bk" items="${list}">
         <tr>
	      <td>${bk.id}</td>
	      <td>${bk.bikeId}</td>
	      <td>${bk.showadminId}</td>
	      <td>${bk.status }</td>
	      
	       </tr>
	   </c:forEach>
     </tbody>
   </table>
   <a href="hoome"><button>HOME</button></a> <br><br><br>
 
</body>
</html>