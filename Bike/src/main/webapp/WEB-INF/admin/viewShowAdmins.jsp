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
        <th id="id">Showroom Id</th><th id="id">Showroom Admin Name</th><th id="id">showRoomName</th><th id="id">Email</th><th id="id">showRoomAddress</th>
        <th id="id">showRoomLocation</th>
        <th colspan="2" id="id">Actions</th>
       </tr>
     </thead>
     <tbody>
        <c:forEach var="show" items="${list}">
         <tr>
	      <td>${show.showRoomId}</td>
	      <td>${show.userName}</td>
	      <td>${show.showRoomName}</td>
	      <td>${show.email }</td>
	      <td>${show.showRoomAddress}</td>
	      <td>${show.showRoomLocation }</td>
	      
	      <td><a href="ashowdelete/${show.showRoomId}">Delete<a/></td>
	       </tr>
	   </c:forEach>
     </tbody>
   </table>
   <br><br><br>
   <a href="home"><button>HOME</button></a> 
 
</body>
</html>