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
		console.log("not changed the value" + returnval + " " + firstname);
	} else {
		setError("uname", "");
	}
	
	let password = document.forms["myForm"]["password"].value.trim();
	if (password == "" || firstname == null) {
		setError("pass", "*Password should not be empty.");
		returnval = false;
		console.log("not changed the value" + returnval + " " + firstname);
	} else {
		setError("pass", "");
	}
	
	let contact = document.forms["myForm"]["contact"].value.trim();
	if (contact == "" || contact == null) {
		setError("contact", "*Contact number should not be empty.");
		returnval = false;
		console.log("not changed the value" + returnval + " " + firstname);
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

