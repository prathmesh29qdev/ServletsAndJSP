<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Employee Registrations</title>
	<link rel="stylesheet" href="css/employeeRegistration.css"
		type="text/css">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
		crossorigin="anonymous">
</head>
<body style="height: fit-content; background-repeat: no-repeat; background-size: cover; background-image: url('images/image.jpg')">
	<div style="width: 100%; display: flex; margin-top: 8%">
		<div class="card-body" style="margin-left: 0px; background-color: white; margin-left: 23%; margin-right: 23%; border-radius: 3%">
			<c:if test="${recordToBeEdited != null}">
				<h2 style="margin-left: 37%; margin-bottom: 45px">Update
					Details</h2>
			</c:if>

			<c:if test="${recordToBeEdited == null}">
				<h2 style="margin-left: 29%; margin-bottom: 45px">Employee
					Register Form</h2>
			</c:if>

			<div>
				<c:if test="${recordToBeEdited != null}">
					<form action="register" method="post" name="myForm" class="classform"
						onsubmit="return validateForm()" style="margin-left: 11%">
				</c:if>
				<c:if test="${recordToBeEdited == null}">
					<form method="post" action="register" name="myForm"
						class="classform" onsubmit="return validateForm()"
						style="margin-left: 11%">
				</c:if>

					<c:if test="${recordToBeEdited != null}">
						<div class="form-group row" id="id">
							<label class="col-sm-2 col-form-label"> Id </label>
							<div class="col-sm-7">
								<input type="text" name="id" class="form-control" id="id"
									name="id" autocomplete="off" placeholder="Enter first name" maxlength="15"
									value="<c:out value='${recordToBeEdited.id}' default='${employeeRecords.id}'/>"
									readonly="readonly"> <span class="formError"></span>
							</div>
						</div>
					</c:if>
	
					<div class="form-group row" id="fname">
						<label class="col-sm-2 col-form-label"> First Name </label>
						<div class="col-sm-7">
							<input type="text" name="firstname" class="form-control"
								id="firstname" name="firstname"
								onkeyup="return validateFirstname()" maxlength="15"
								placeholder="Enter first name" autocomplete="off"
								value="<c:out value='${recordToBeEdited.firstName}' default='${employeeRecords.firstName}'/>">
							<span class="formError"></span>
						</div>
					</div>
					<div class="form-group row" id="lname">
						<label class="col-sm-2 col-form-label"> Last Name </label>
						<div class="col-sm-7">
							<input type="text" name="lastname" id="lastname"
								class="form-control" onkeyup="return validateLastname()"
								placeholder="Enter last name" autocomplete="off" maxlength="15"
								value="<c:out value='${recordToBeEdited.lastName}' default='${employeeRecords.lastName}'/>">
							<span class="formError"></span> <span class="formError"></span>
						</div>
					</div>
					<div class="form-group row" id="uname">
						<label class="col-sm-2 col-form-label"> User Name </label>
						<div class="col-sm-7">
							<input type="text" name="username" class="form-control"
								id="username" onkeyup="return validateUsername()" onkeypress="checkUserNameDuplicate()"
									onblur="checkUserNameDuplicate()"
								placeholder="Enter username" autocomplete="off" maxlength="15"
								value="<c:out value='${recordToBeEdited.userName}' default='${employeeRecords.userName}'/>">
							<span id="userError" class="formError"> <%=((String) request.getAttribute("userError")) != null ? (String) request.getAttribute("userError") : ""%>
							</span>
						</div>
					</div>
	
					<div class="form-group row" id="pass">
						<label class="col-sm-2 col-form-label"> Password </label>
						<div class="col-sm-7">
							<input type="password" name="password" pattern="[A-Za-z,0-9]{1,32}"
								class="form-control" id="password"
								onkeyup="return validatePassword()" placeholder="Enter password"
								autocomplete="off" maxlength="15"
								value="<c:out value='${recordToBeEdited.password}' default='${employeeRecords.password}'/>">
							<span class="formError"></span>
						</div>
					</div>
	
					<div class="form-group row" id="add">
						<label class="col-sm-2 col-form-label"> Address </label>
						<div class="col-sm-7">
							<input type="text" name="address" class="form-control"
								autocomplete="off" id="address" maxlength="50"
								onkeyup="return validateAddress()" placeholder="Enter address"
								value="<c:out value='${recordToBeEdited.address}' default='${employeeRecords.address}'/>">
							<span class="formError"></span>
						</div>
					</div>
	
					<div class="form-group row" id="email">
						<label class="col-sm-2 col-form-label"> Email id </label>
						<div class="col-sm-7">
							<input type="text" name="emailId" class="form-control"
								autocomplete="off" id="emailId" onkeyup="return validateEmail()"
								placeholder="Enter email Id" maxlength="50" onkeypress="checkForDuplicate()" onblur="checkForDuplicate()"
								value="<c:out value='${recordToBeEdited.email}' default='${employeeRecords.email}'/>">
							<span id="emailError" class="formError"> <%=((String) request.getAttribute("emailError")) != null ? (String) request.getAttribute("emailError") : ""%>
							</span>
						</div>
					</div>
	
					<div class="form-group row" id="contact">
						<label class="col-sm-2 col-form-label"> Contact Number </label>
						<div class="col-sm-7">
							<input type="text" name="contact" class="form-control"
								autocomplete="off" id="contactt" onkeyup="return validateContact()"
								placeholder="Enter contact number" maxlength="10" onkeypress="checkContactDuplicate()" onblur="checkContactDuplicate()"
								value="<c:out value='${recordToBeEdited.contact}' default='${employeeRecords.contact}'/>">
							<span id="contactError" class="formError"> <%=((String) request.getAttribute("contactError")) != null ? (String) request.getAttribute("contactError") : ""%>
							</span>
						</div>
					</div>
					<c:if test="${recordToBeEdited != null}">
						<button type="submit" class="btn btn-outline-primary"
							style="width: 43%; margin-left: 178px; margin-top: 22px">
							Update</button>
					</c:if>
					<c:if test="${recordToBeEdited == null}">
						<button type="submit" class="btn btn-outline-primary"
							style="width: 43%; margin-left: 178px; margin-top: 22px">
							Save</button>
					</c:if>
				</form>
				<c:if test="${recordToBeEdited != null}">
					<form action="showAllRecords" method="get"
						style="margin-top: 10px;">
						<button type="submit" class="btn btn-outline-dark"
							style="margin-top: 1px; margin-left: 285px; width: 38%; background-color: transparent; color: black">Cancel</button>
					</form>
				</c:if>
				<form action="showAllRecords" method="get" style="margin-top: 10px;">
					<button type="submit" class="btn btn-outline-dark"
						style="margin-left: 275px; width: 40%; background-color: transparent; color: black">Show
						All Records</button>
				</form>
			</div>
		</div>
	</div>
	<script src="js/script.js" type="text/javascript"></script>
</body>
</html>