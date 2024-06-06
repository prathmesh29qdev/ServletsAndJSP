<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body style="height: fit-content;background-repeat:no-repeat;background-size: cover; background-image: url('images/image.jpg')">
<div class="card-body" style="background-color:white;margin-left: 9%;margin-right: 9%; border-radius: 2%;width: 82%;margin-top: 9%">
<div style="padding-top: 10%;">
		<h2 class="successmessage" style=" border: green 3px solid; padding: 62px 318px">
		The user with Username: <%=((String) request.getAttribute("user"))%> has been deleted successfully.</h2><br>
		<h2> Thank You</h2>
	</div>
	<div style="padding-left: 45%;margin-top:40px; margin-bottom: 25px">
			<form action="EmployeeRegistration.jsp">
			<button type="submit" class="btn btn-outline-primary" style="width:30%;margin-left:-7%"> Register another employee</button>
		</form>
	</div>
		<form action="showAllRecords" method="get" style="margin-top:10px; width 100%">
        <button type="submit" class="btn btn-outline-primary" style="margin-left: 440px;width:40%; background-color: transparent;color: black">Show All Records</button>
    </form>
    </div>
</body>
</html>