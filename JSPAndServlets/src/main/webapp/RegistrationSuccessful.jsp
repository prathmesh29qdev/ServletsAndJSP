<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/RegistrationSuccessful.css" type="text/css">
</head>
<body>
	<div style="padding-top: 10%">
		<h1 class = "successmessage">
			Registration Successful</h1>
	</div>
	<div class = "tabcontainer">
	<table style="" class = "successtable">
			<tr>
				<th><label> First Name </label></th>
				<td class = "dash"> - </td>
				<td class = "values">
					<%= request.getParameter("firstname")%>
				</td>
			</tr>
			<tr>
				<th><label> Last Name </label></th>
				<td class = "dash"> - </td>
				<td class = "values">	
					<%= request.getParameter("lastname") %>
				</td>
			</tr>
			<tr>
				<th><label> Username </label></th>
				<td class = "dash"> - </td>
				<td class = "values">
				<%=  request.getParameter("username") %>
				</td>
			</tr>
			<tr>
				<th><label> Password </label></th>
				<td class = "dash"> - </td>
				<td class = "values">
					<%=  request.getParameter("password") %>
				</td>
			</tr>
			<tr>
				<th><label> Address </label></th>
				<td class = "dash"> - </td>
				<td class = "values">
					<%= request.getParameter("address")%>
				</td>
			</tr>
			<tr>
				<th><label> Contact No. </label></th>
				<td class = "dash"> - </td>
				<td class = "values">
					<%= request.getParameter("contact") %>
				</td>
			</tr>
		</table>
		</div>
	<div style="padding-left: 45%;">
		<form action="EmployeeRegistration.jsp">
			<input type="submit" value="Register another employee">
		</form>
	</div>
</body>
</html>