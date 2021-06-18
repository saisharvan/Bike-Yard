<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bike Form</title>
</head>
<body>
	<h1>Add Bike</h1>
	<form:form action="save" modelAttribute="bike" method="post">
		<table>
			<tr>
				<td>Bike Name:</td>
				<td><form:input path="bikeName" /></td>
			</tr>
			<tr>
				<td>Bike Cost:</td>
				<td><form:input path="bikeCost" /><br /></td>
			</tr>
			<tr>
				<td>Bike Color:</td>
				<td><form:select path="bikeColor">
						<form:option value="red" label="red"></form:option>
						<form:option value="blue" label="blue"></form:option>
						<form:option value="black" label="black"></form:option>
					</form:select></td>
			</tr>
			<tr>
			 <td>Bike Description:</td>
			 <td><form:textarea path="bikeDescription"></form:textarea>
			 </td>
			</tr>
			
			<tr>
			 <td>Bike Availability:</td>
			 <td>
			  Yes:<form:radiobutton path="availability" value="yes"/>
			  No:<form:radiobutton path="availability" value="no"/>
             </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add Bike" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>