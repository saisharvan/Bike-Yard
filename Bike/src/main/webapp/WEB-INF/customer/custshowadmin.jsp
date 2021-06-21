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
       <th>Showroom Admin Name</th><th>showRoomName</th><th>Email</th><th>showRoomAddress</th>
        <th>showRoomLocation</th>
        <th colspan="2">Actions</th>
       </tr>
     </thead>
     <tbody>
        <c:forEach var="show" items="${list}">
         <tr>
	      <td>${show.userName}</td>
	      <td>${show.showRoomName}</td>
	      <td>${show.email }</td>
	      <td>${show.showRoomAddress}</td>
	      <td>${show.showRoomLocation }</td>
	      
	      <td><a href="custview/${show.showRoomId}">Viwe Bikes<a/></td>
	       </tr>
	   </c:forEach>
     </tbody>
   </table>
   <br><br><br>
   <a href="/Bike/hoome"><button>HOME</button></a> 
 
</body>
</html>