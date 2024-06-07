<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Update Successful</title>
	<link rel="stylesheet" href="css/registrationSuccessful.css"
		type="text/css">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous">
</head>
<body style="height: fit-content; background-repeat: no-repeat; background-size: cover; background-image: url('images/image.jpg')">
	<div class="card-body"
		style="background-color: white; margin-left: 9%; margin-right: 9%; border-radius: 2%; width: 82%; margin-top: 9%">
		<div style="padding-top: 5%">
			<h1 style="margin-bottom: 43px; margin-left: 38%; margin-top: -31px">Update
				Successful</h1>
		</div>
		<div class="tabcontainer">
			<table style="" class="successtable">
				<tr>
					<th><label> First Name </label></th>
					<td class="dash">-</td>
					<td class="values"><%=request.getParameter("firstname")%></td>
				</tr>
				<tr>
					<th><label> Last Name </label></th>
					<td class="dash">-</td>
					<td class="values"><%=request.getParameter("lastname")%></td>
				</tr>
				<tr>
					<th><label> Username </label></th>
					<td class="dash">-</td>
					<td class="values"><%=request.getParameter("username")%></td>
				</tr>
				<tr>
					<th><label> Password </label></th>
					<td class="dash">-</td>
					<td class="values"><%=request.getParameter("password")%></td>
				</tr>
				<tr>
					<th><label> Address </label></th>
					<td class="dash">-</td>
					<td class="values"><%=request.getParameter("address")%></td>
				</tr>
				<tr>
					<th><label> Contact Number </label></th>
					<td class="dash">-</td>
					<td class="values"><%=request.getParameter("contact")%></td>
				</tr>
			</table>
		</div>
		<div style="padding-left: 45%;">
			<form action="EmployeeRegistration.jsp">
				<button type="submit" class="btn btn-outline-primary"
					style="width: 30%; margin-left: -7%">Register another
					employee</button>
			</form>
		</div>
		<form action="showAllRecords" method="get" style="margin-top: 10px;">
			<button type="submit" class="btn btn-outline-primary"
				style="margin-left: 429px; width: 40%; background-color: transparent; color: black">Show
				All Records</button>
		</form>
	</div>
</body>
</html>