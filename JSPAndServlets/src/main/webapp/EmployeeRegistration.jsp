<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registrations</title>
<link href = "css/EmployeeRegistration.css"  type = "text/css"/>
</head>
<body>
	<h1 style = 'text-align: center;'> Employee Register Form</h1>
	
	<form action="register" method="post" style = 'text-align: center; box-sizing: border-box; width: 15%; margin: 0 auto;' class = "formClass">
	<label> First Name </label> <input type = "text" name = "firstname"><br><br>
	<label> Last Name </label> <input type = "text" name = "lastname"><br><br>
	<label> Username </label> <input type = "text" name = "username"><br><br>
	<label> Passward </label> <input type = "password" name = "password"><br><br>
	<label> Address </label> <input type = "text" name = "address"><br><br>
	<label> Contact No. </label> <input type = "text" name = "contact" maxlength="10"><br><br>
	<input type="submit" value = "Register">
	</form>
	<h1 style = 'text-align: center;'> This is a JSP page</h1>
	<%
		String name = "Mahesh";
		int length = name.length();
	%>
	<h3 style = 'text-align: center;'> <%= length %> </h3>
</body>
</html>