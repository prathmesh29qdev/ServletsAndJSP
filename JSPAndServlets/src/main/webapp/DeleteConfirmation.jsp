<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Delete</title>
<link rel="stylesheet" href="css/DeleteConfirmation.css"
	type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

	<header style="background-repeat:no-repeat;background-size: cover; background-image: url('images/image.jpg');margin-top: 0px; padding: 60px;text-align: center;font-size: 30px">
<h2 style="margin-left:-1%;margin-top:0px; margin-bottom:10px">List of Registered Users</h2>
</header>
    <table style="width:70%; margin-left:15%;margin-top:3%">
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
				<tr>
					<td>${register.id}</td>
					<td>${register.firstName}</td>
                    <td>${register.lastName}</td>
                    <td>${register.user}</td>
                    <td>${register.pass}</td>
                    <td>${register.address}</td>
                    <td>${register.emailId}</td>
                    <td>${register.contact}</td>
                    <td>
				</tr>
			</c:forEach>
		</tbody>
    </table>
   
	
	<div style="width: 50%;height:90%; border: 1px beige #dee2e6; margin: auto;border-style:groove;" class="border border-secondary" id="loading">
		<h4 style="margin-left:158px;margin-top: 20px;margin-bottom: 49px">
			Are you sure you want to delete the <%=((String) request.getAttribute("user"))%> record?
		</h4>
		<div style="margin-bottom: 20px">
		<a style="text-decoration:none; margin-left:30%" href="deleteServlet?user=<%=request.getAttribute("user")%>" > 
			<button class="btn btn-danger">Delete</button> 
		</a>
		<a style="margin-left:24%;text-decoration:none"" href="showAllRecords" >
		<button class="btn btn-secondary">Cancel</button>
		</a>
		</div>
	</div>
</body>
</html>