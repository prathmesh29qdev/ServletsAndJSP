
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
	<form action="register" method="post"
		style='text-align: center; box-sizing: border-box; width: 15%; margin: 0 auto;'
		class="classform">
		<table>
			<tr>
				<td><label> First Name </label></td>
				<td><input type="text" name="firstname"
					pattern="[A-Za-z]{1,32}" class="forminput"
					value="<%=(request.getParameter("firstname") != null) ? request.getParameter("firstname") : ""%>">
				</td>
			</tr>
			<tr>
				<td><label> Last Name </label></td>
				<td><input type="text" name="lastname" pattern="[A-Za-z]{1,32}"
					class="forminput"
					value="<%=(request.getParameter("lastname") != null) ? request.getParameter("lastname") : ""%>">
				</td>
			</tr>
			<tr>
				<td><label> Username </label></td>
				<td><input type="text" name="username" class="forminput"
					value="<%=(request.getParameter("username") != null) ? request.getParameter("username") : ""%>">
				</td>
			</tr>
			<tr>
				<td><label> Password </label></td>
				<td><input type="password" name="password"
					pattern="[A-Za-z,0-9]{1,32}" class="forminput"
					value="<%=(request.getParameter("password") != null) ? request.getParameter("password") : ""%>">
				</td>
			</tr>
			<tr>
				<td><label> Address </label></td>
				<td><input type="text" name="address" class="forminput"
					value="<%=(request.getParameter("address") != null) ? request.getParameter("address") : ""%>">
				</td>
			</tr>
			<tr>
				<td><label> Contact No. </label></td>
				<td><input type="text" name="contact" pattern="[9/8/7/6]\{10-12)"
					class="forminput"
					value="<%=(request.getParameter("contact") != null) ? request.getParameter("contact") : ""%>">
				</td>
			</tr>
		</table>
		<input type="submit" value="Submit" class="submit">
	</form>
</body>
</html>