<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Show Profile Details</title>
</head>
<body style="text-align:center">
<h1 style="text-align:center">Showroom Admin details are hear</h1><br><br>

<form:form modelAttribute="show" action="showedit/${show.showRoomId }">
	<h3>Showroom ID         =  		${show.showRoomId }<br></h3> 
    <h3>Showroom Admin Name =	    ${show.userName}<br></h3>
    <h3>Showroom Name       =   	${show.showRoomName}<br></h3>
    <h3>Email               =       ${show.email}<br></h3> 
    <h3>Address             =       ${show.showRoomAddress}<br></h3> 
    <h3>location            =       ${show.showRoomLocation}<br></h3> 
    <input type="submit" value="Edit Data" />			
	</form:form>
</body>
</html>





