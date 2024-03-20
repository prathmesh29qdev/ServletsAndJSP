function setError(id, error) {
	var element = document.getElementById(id);
	element.getElementsByClassName('formError')[0].innerHTML = error;
	console.log("in error " + element.textContent);
}

function validateForm() {
	var returnval = true;
	var firstname = document.forms["myForm"]["firstname"].value.trim();
	console.log("get element " + firstname);
	let regex = /^[A-Za-z]+$/;

	if (firstname == "" || firstname == null) {
		setError("fname", "*First name should not be empty.");
		returnval = false;
		console.log("not changed the value" + returnval + " " + firstname);
	} else if (firstname != "" && firstname != null) {
		console.log("value of fname in if " + firstname + " " + regex.test(firstname));
		if (!regex.test(firstname)) {
			console.log("test value in if for fname " + regex.test(firstname))
			setError("fname", "*Name should only have alphabets");
			returnval = false;
		} else {
			setError("fname", "");
		}
	}

	let lastname = document.forms["myForm"]["lastname"].value.trim();
	if (lastname != "" && lastname != null) {
		console.log("value of lname in if " + lastname + " " + regex.test(lastname));
		if (!regex.test(lastname)) {
			console.log("test value in if for lname " + regex.test(lastname))
			setError("lname", "*Name should only have alphabets");
			returnval = false;
		}
	}

	let username = document.forms["myForm"]["username"].value.trim();
	if (username == "" || username == null) {
		setError("uname", "*User name should not be empty.");
		returnval = false;
		console.log("not changed the value" + returnval + " " + username);
	} else {
		setError("uname", "");
	}

	let password = document.forms["myForm"]["password"].value.trim();
	if (password == "" || firstname == null) {
		setError("pass", "*Password should not be empty.");
		returnval = false;
		console.log("not changed the value" + returnval + " " + password);
	} else {
		setError("pass", "");
	}
	
	console.log("email value ");
	let emailid = document.forms["myForm"]["emailId"].value.trim();
	emailExpression = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
	console.log("email value " + emailid);
	if (emailid == "" || emailid == null) {
		setError("email", "*Email id should not be empty.");
		returnval = false;
		console.log("not changed the value in email" + returnval + " " + emailid);
	} else if (emailid != "" && emailid != null) {
		console.log("value of fname in if " + emailid + " " + regex.test(emailid));
		if (!emailExpression.test(emailid)) {
			console.log("test value in if for email " + emailExpression.test(emailid))
			setError("email", "*Email id should be in proper format.");
			returnval = false;
		} else {
			setError("email", "");
		}
	}

	let contact = document.forms["myForm"]["contact"].value.trim();
	if (contact == "" || contact == null) {
		setError("contact", "*Contact number should not be empty.");
		returnval = false;
		console.log("not changed the value" + returnval + " " + contact);
	} else if (contact != "" && contact != null) {
		let regex1 = /^(0|91)?[0-9]\d{9}$/;
		if (!regex1.test(contact)) {
			setError("contact", "*Contact number should have only 10 digits.");
			returnval = false;
			console.log("contact matching");
		} else {
			setError("contact", "");
		}
	}

	return returnval;
}

function validateFirstname() {
	var returnval = true;
	var firstname = document.forms["myForm"]["firstname"].value.trim();
	let regex = /^[A-Za-z]+$/;
	if (firstname == "" || firstname == null) {
		setError("fname", "*First name should not be empty.");
		returnval = false;
		console.log("not changed the value" + returnval + " " + firstname);
	} else if (firstname != "" && firstname != null) {
		console.log("value of fname in if " + firstname + " " + regex.test(firstname));
		if (!regex.test(firstname)) {
			console.log("test value in if for fname " + regex.test(firstname))
			setError("fname", "*Name should only have alphabets");
			returnval = false;
		} else {
			setError("fname", "");
		}
	}
	return returnval;
}

function validateLastname() {
	var returnval = true;
	let regex = /^[A-Za-z]+$/;
	let lastname = document.forms["myForm"]["lastname"].value.trim();
	if (lastname != "" && lastname != null) {
		console.log("value of lname in if " + lastname + " " + regex.test(lastname));
		if (!regex.test(lastname)) {
			console.log("test value in if for lname " + regex.test(lastname))
			setError("lname", "*Name should only have alphabets");
			returnval = false;
		}
	}
	return returnval;
}

function validateUsername() {
	var returnval = true;
	let username = document.forms["myForm"]["username"].value.trim();
	if (username == "" || username == null) {
		setError("uname", "*User name should not be empty.");
		returnval = false;
		console.log("not changed the value" + returnval + " " + username);
	} else {
		setError("uname", "");
	}
	return returnval;
}

function validatePassword() {
	var returnval = true;
	let password = document.forms["myForm"]["password"].value.trim();
	if (password == "" || firstname == null) {
		setError("pass", "*Password should not be empty.");
		returnval = false;
		console.log("not changed the value" + returnval + " " + password);
	} else {
		setError("pass", "");
	}
	return returnval;
}

function validateEmail() {
	var returnval = true;
	let emailid = document.forms["myForm"]["emailId"].value.trim();
	emailExpression = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
	console.log("email value " + emailid);
	if (emailid == "" || emailid == null) {
		setError("email", "*Email id should not be empty.");
		returnval = false;
		console.log("not changed the value in email" + returnval + " " + emailid);
	} else if (emailid != "" && emailid != null) {
		console.log("value of fname in if " + emailid + " " + regex.test(emailid));
		if (!emailExpression.test(emailid)) {
			console.log("test value in if for email " + emailExpression.test(emailid))
			setError("email", "*Email id should be in proper format.");
			returnval = false;
		} else {
			setError("email", "");
		}
	}
	return returnval;
}

function validateContact() {
	var returnval = true;
	let contact = document.forms["myForm"]["contact"].value.trim();
	if (contact == "" || contact == null) {
		setError("contact", "*Contact number should not be empty.");
		returnval = false;
		console.log("not changed the value" + returnval + " " + contact);
	} else if (contact != "" && contact != null) {
		let regex1 = /^(0|91)?[0-9]\d{9}$/;
		if (!regex1.test(contact)) {
			setError("contact", "*Contact number should have only 10 digits.");
			returnval = false;
			console.log("contact matching");
		} else {
			setError("contact", "");
		}
	}
	return returnval;
}