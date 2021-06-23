   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Customer details</title>
</head>

<body>
<table border="2">  
<tr><th id="id">S.No</th><th id="id">FirstName</th><th id="id">LastName</th><th id="id">Age<th id="id">Gender</th><th id="id">Email</th><th id="id">Phone Number</th><th id="id">Address</th><th id="id">Delete</th></tr>  
   <c:forEach var="s" items="${list}">   
   <tr> 
   <td>${s.id }</td> 
   <td>${s.firstname}</td> 
   <td>${s.lastname}</td> 
    <td>${s.age}</td> 
     <td>${s.gender}</td> 
      <td>${s.email}</td> 
      <td>${s.num}</td> 
      <td>${s.address}</td> 
   <td><a href="deletecustomer/${s.id}">Delete</a></td>    
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="/Bike/add?Id=Share&Pass=1998"><button>HOME</button></a>
</body>


</html>