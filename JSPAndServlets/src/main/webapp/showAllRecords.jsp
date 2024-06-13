<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Employees List</title>
	<link rel="stylesheet" href="css/showAllRecords.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>
<body>
	<header style="background-repeat: no-repeat; background-size: cover; background-image: url('images/image.jpg'); margin-top: 0px; padding: 60px; text-align: center; font-size: 30px">
		<h2 style="margin-left: -1%; margin-top: 0px; margin-bottom: 10px">List
			of Registered Employees</h2>
	</header>
	<div style="float: left; margin-left: 79%; margin-bottom: 40px; margin-top: 20px; display: flex">
		<form action="employeeRegistration.jsp">
			<button id="plusButton" type="submit" style="margin-top: 10px; width: 114px; border: none; padding: 0; background: none; border: 0px white; border: none; background-color: white; height: 49px; text-decoration: none">
				<img SRC="images/plus.png" width="24px" height="25px">
			</button>
		</form>
		<c:if test="${deletedUser != null}">
			<div>
				<script>
				Swal.fire({
					icon: "success",
					title: "The record for user ${deletedUser} has been deleted.",
					showConfirmButton: false,
					timer: 1500
					});
			</script>
			</div>
		</c:if>
	</div>
	<table id="myTable" class="table table-dark" style="width: 70%; margin-left: 15%; margin-top: 3%">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">User Name</th>
				<th scope="col">Password</th>
				<th scope="col">Address</th>
				<th scope="col">Email ID</th>
				<th scope="col">Contact</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${registerList}" var="register">
				<tr class="specific">
					<td><c:out value="${register.id}" /></td>
					<td>${register.firstName}</td>
					<td>${register.lastName}</td>
					<td>${register.userName}</td>
					<td>${register.password}</td>
					<td>${register.address}</td>
					<td>${register.email}</td>
					<td>${register.contact}</td>
					<td>
						<p>
							<a style="text-decoration: none"
								href="editServlet?id=<c:out value='${register.id}'/>">
								<img SRC="images/edit.png" width="12px" height="12px">
							</a>
							<a style="text-decoration: none"> <img SRC="images/or.png"
								width="12px" height="12px">
							</a>
							<a style="text-decoration: none" href="#"
								onclick="toggleDivVisibility();storeValue('${register.userName}', '${register.id}')">
								<img SRC="images/bin.png" width="12px" height="12px">
							</a>
						</p>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<div style="margin-left: 79%;" id="myPopup">
			<%
			var partition = (int) request.getAttribute("partition");
			%>
			<%
			int count = 1;
			%>
			<%
			System.out.println(count + " and partition" + partition);
			%>
			<%
			while (count <= partition) {
			%>
			<div style="float: left;">
				<a style="text-decoration: none; padding: 5px 11px; color: black; border: 1px solid grey; border-radius: 60% !important; margin: 0 3px"
					href='showAllRecords?page=<%=count%>'><%=count%></a>
			</div>
			<%
			count++;
			%>
			<%
			}
			%>

			<a style="text-decoration: none"> <img SRC="images/forward.png"
				width="12px" height="12px">
			</a> 
			<a style="text-decoration: none; color: black;">
				<%=request.getAttribute("numberOfRecords")%>
			</a>
		</div>
	</div>
	<div id="myDiv"
		style="display: none; width: 50%; height: 90%; border: 1px beige #dee2e6; margin-top: 2%; margin-left: 25%; border-style: groove;"
		class="border border-secondary">
		<div style="margin-bottom: 20px">
			<form action="deleteServlet" method="post"
				style="float: left; margin-left: 242px">
				<div>
					<h4
						style="margin-left: -21px; margin-top:19px; margin-bottom: 32px">
						Are you sure you want to delete the <span id="storedValueInput"></span> record?
					</h4>
					<input id="storedValueInputs" name="storedValue" type="hidden">
					<input id="idToBeDeleted" name="idToBeDeleted" type="hidden">
				</div>
				<div style="width: 79%">
					<a style="text-decoration: none;" href="deleteServlet">
						<button class="btn btn-danger" style="width: 56%; margin-bottom: 20px; margin-left: 116px">Delete</button>
					</a>
				</div>
			</form>
			<a style="margin-left: 24%; text-decoration: none" href="showAllRecords">
				<button class="btn btn-secondary"
					style="width: 56%; margin-left: -29px">Cancel</button>
			</a>
		</div>
	</div>
	<script src="js/showAllRecords.js" type="text/javascript"></script>
</body>
<footer style="margin-bottom: 0px">
	<h3 style="margin-top: 5%; margin-left: 34%; color: grey">*Register any employee and see in the list if it has been added.</h3>
</footer>
</html>