<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registrations</title>
<link rel="stylesheet" href="css/EmployeeRegistration.css"
	type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<style>   
 td { text-align: justify; }
 td::after {
    content: attr(data-content);
    display: inline-block;
    width: 100%; }
</style>
</head>
<body style="height: fit-content;background-repeat:no-repeat;background-size: cover; background-image: url('images/image.jpg')">
<!-- <header style="background-image: linear-gradient(#f8f8ff,#d3d3d3);margin-top: 0px; padding: 60px;text-align: center;font-size: 30px">
<h2 style="margin-left:-4%;margin-top:0px; margin-bottom:10px">Employee Register Form</h2>
</header> -->
	
	  <div  style="width:100%; display:flex; margin-top: 8%">
	 <!--  <div style="float: left; background-color: #AEB6BF; width: 30%; height: 489px">
	  	<form action="showAllRecords" method="get" style="margin-top:10px; width 100%">
        <button type="submit" class="btn btn-outline-dark" style="margin-left: 145px;width:40%; background-color: transparent;color: black">Show All Records</button>
    </form>
	  </div> -->
   		<div class="card-body" style="margin-left: 0px;background-color:white;margin-left: 23%;margin-right: 23%; border-radius: 3%">
   		
   		<c:if test="${editRow != null}">
   		<h2 style="margin-left:37%; margin-bottom:45px">Update Details</h2>
   		</c:if>
   		
   		<c:if test="${editRow == null}">
   		<h2 style="margin-left:29%; margin-bottom:45px">Employee Register Form</h2>
   		</c:if>
   	
   		<div>
    		<c:if test="${editRow != null}">
				<form action="update" method="post" name="myForm" class="classform"
				onsubmit="return validateForm()" style="margin-left: 11%">
			</c:if>
			<c:if test="${editRow == null}">
				<form method="post" action="register" name="myForm" class="classform"
				onsubmit="return validateForm()" style="margin-left: 11%">
			</c:if>
	
			<c:if test="${editRow != null}">
				<div class="form-group row" id="id">
					<label class="col-sm-2 col-form-label"> Id </label>
					<div class="col-sm-7">
						<input type="text" name="id" class="form-control"
							id="id" name="id" autocomplete="off"
							placeholder="Enter first name"
							value="<c:out value='${editRow.id}' default='${rowStill.id}'/>" readonly="readonly">
						<span class="formError"></span>
					</div>
				</div>
			</c:if>
			
			<div class="form-group row" id="fname">
				<label class="col-sm-2 col-form-label"> First Name </label>
				<div class="col-sm-7">
					<input type="text" name="firstname" class="form-control"
						id="firstname" name="firstname"
						onkeyup="return validateFirstname()"
						placeholder="Enter first name" autocomplete="off"
						value="<c:out value='${editRow.firstName}' default='${rowStill.firstName}'/>">
					<span class="formError"></span>
				</div>
			</div>
			<div class="form-group row" id="lname">
				<label class="col-sm-2 col-form-label"> Last Name </label>
				<div class="col-sm-7">
					<input type="text" name="lastname" id="lastname"
					class="form-control" onkeyup="return validateLastname()" placeholder="Enter last name"
					autocomplete="off"
					value="<c:out value='${editRow.lastName}' default='${rowStill.lastName}'/>">
					<span class="formError"></span>
					<span class="formError"></span>
				</div>
			</div>
			<div class="form-group row" id="uname">
				<label class="col-sm-2 col-form-label"> User Name </label>
				<div class="col-sm-7">
			<%-- 	<c:if test="${editRow != null}">
				<input type="text" name="username" class="form-control"
					id="username" onkeyup="return validateUsername()" placeholder="Enter username"
					value="<c:out value='${editRow.user}' default='${rowStill.user}'/>" readonly="readonly">
			</c:if> --%>
		<%-- 	<c:if test="${editRow == null}"> --%>
				<input type="text" name="username" class="form-control"
					id="username" onkeyup="return validateUsername()" placeholder="Enter username" autocomplete="off"
					value="<c:out value='${editRow.user}' default='${rowStill.user}'/>">
			<%-- </c:if> --%>
					<%-- <input type="text" name="username" class="form-control"
					id="username" onkeyup="return validateUsername()" placeholder="Enter username"
					value="<c:out value='${editRow.user}' default='${rowStill.user}'/>"> --%>
					<span class="formError"> <%=((String) request.getAttribute("userError")) != null ? (String) request.getAttribute("userError") : ""%>
				</span>
				</div>
			</div>
			
			<div class="form-group row" id="pass">
				<label class="col-sm-2 col-form-label"> Password </label>
				<div class="col-sm-7">
					<input type="text" name="password"
					pattern="[A-Za-z,0-9]{1,32}" class="form-control" id="password"
					onkeyup="return validatePassword()" placeholder="Enter password" autocomplete="off"
					value="<c:out value='${editRow.pass}' default='${rowStill.pass}'/>">
					<span class="formError"></span>
				</div>
			</div>

			<div class="form-group row" id="add">
				<label class="col-sm-2 col-form-label"> Address </label>
				<div class="col-sm-7">
					<input type="text" name="address" class="form-control" autocomplete="off"
					id="address" onkeyup="return validateAddress()" placeholder="Enter address"
					value="<c:out value='${editRow.address}' default='${rowStill.address}'/>">
					<span class="formError"></span>
				</div>
			</div>
			
			<div class="form-group row" id="email">
				<label class="col-sm-2 col-form-label"> Email id </label>
				<div class="col-sm-7">
					<input type="text" name="emailId" class="form-control" autocomplete="off"
					id="emailId" onkeyup="return validateEmail()" placeholder="Enter email Id"
					value="<c:out value='${editRow.emailId}' default='${rowStill.emailId}'/>">
					<span class="formError"> <%=((String) request.getAttribute("emailError")) != null ? (String) request.getAttribute("emailError") : ""%>
				</span>
				</div>
			</div>
		
		<div class="form-group row" id="contact">
				<label class="col-sm-2 col-form-label"> Contact Number </label>
				<div class="col-sm-7">
					<input type="text" name="contact" class="form-control" autocomplete="off"
					id=contact onkeyup="return validateContact()" placeholder="Enter contact number"
					value="<c:out value='${editRow.contact}' default='${rowStill.contact}'/>">
					<span class="formError"> <%=((String) request.getAttribute("contactError")) != null ? (String) request.getAttribute("contactError") : ""%>
					</span>
				</div>
			</div>
			<c:if test="${editRow != null}">
				<button type="submit" class="btn btn-outline-primary" style="width:43%;margin-left: 178px; margin-top:22px"> Update </button>
			</c:if>
			<c:if test="${editRow == null}">
				<button type="submit" class="btn btn-outline-primary" style="width:43%;margin-left: 178px; margin-top:22px"> Save </button>
			</c:if>
    </form>
			<c:if test="${editRow != null}">
			  	<form action="showAllRecords" method="get" style="margin-top:10px; width 100%">
			        <button type="submit" class="btn btn-outline-dark" style="margin-top:1px;margin-left: 285px;width: 38%; background-color: transparent;color: black">Cancel</button>
			    </form>
   		 	</c:if>
	<form action="showAllRecords" method="get" style="margin-top:10px; width 100%">
        <button type="submit" class="btn btn-outline-dark" style="margin-left: 275px;width:40%; background-color: transparent;color: black">Show All Records</button>
    </form>
    </div>
   </div>
  </div>
	<script src="js/script.js" type="text/javascript"></script>
</body>
</html>