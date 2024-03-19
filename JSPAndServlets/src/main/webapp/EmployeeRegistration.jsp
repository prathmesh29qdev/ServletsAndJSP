<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registrations</title>
<link rel="stylesheet" href="css/EmployeeRegistration.css"
	type="text/css">
</head>
<body>
	<h1 style='text-align: center; padding-top: 4%; font-size: 45px'>
		Employee Register Form</h1>
	<form  method="post" action="register" name = "myForm"
		class="classform" onsubmit="return validateForm()">
		<table class = "tabledata">
			<tr id = "fname">
				<td><label> First Name </label></td>
				<td><input type="text" name="firstname" 
					class="forminput" id = "firstname" name = "firstname"
					value="<%=(request.getParameter("firstname") != null) ? request.getParameter("firstname") : ""%>">
					<span class = "formError"></span>
				</td>
			</tr>
			<tr id = "lname">
				<td><label> Last Name </label></td>
				<td><input type="text" name="lastname" id = "lastname"
					class="forminput"
					value="<%=(request.getParameter("lastname") != null) ? request.getParameter("lastname") : ""%>">
					<span class = "formError"></span>
				</td>
			</tr>
			<tr id = "uname">
				<td><label> Username </label></td>
				<td><input type="text" name="username" class="forminput" id = "username"
					value="<%=(request.getParameter("username") != null) ? request.getParameter("username") : ""%>" >
					<span class = "formError"></span>
				</td>
			</tr>
			<tr id = "pass">
				<td><label> Password </label></td>
				<td><input type="password" name="password"
					pattern="[A-Za-z,0-9]{1,32}" class="forminput" id = "password"
					value="<%=(request.getParameter("password") != null) ? request.getParameter("password") : ""%>" >
					<span class = "formError"></span>
				</td>
			</tr>
			<tr id = "add">
				<td><label> Address </label></td>
				<td><input type="text" name="address" class="forminput" id = "address"
					value="<%=(request.getParameter("address") != null) ? request.getParameter("address") : ""%>">
					<span class = "formError"></span>
				</td>
			</tr>
			<tr id = "contact">
				<td><label> Contact No. </label></td>
				<td><input type="text" name="contact" 
					class="forminput" id = contact
					value="<%=(request.getParameter("contact") != null) ? request.getParameter("contact") : ""%>" >
					<span class = "formError"></span>
				</td>
			</tr>
		</table>
		<input type="submit" value="Submit" class="submit">
	</form>
	<script src="js/script.js" type="text/javascript"></script> 
</body>
</html>