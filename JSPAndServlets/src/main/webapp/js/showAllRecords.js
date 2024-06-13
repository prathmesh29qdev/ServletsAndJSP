var isButtonClicked = false;
		function toggleDivVisibility() {
			isButtonClicked = !isButtonClicked;
			document.getElementById("myDiv").style.display = isButtonClicked ? "block"
					: "none";
			document.getElementById("myTable").style.display = isButtonClicked ? "none"
					: "block";
			document.getElementById("myPopup").style.display = isButtonClicked ? "none"
					: "block";
			document.getElementById("plusButton").style.display = isButtonClicked ? "none"
					: "block";
		}

		function storeValue(userNameValue, idValue) {
			document.getElementById("storedValueInputs").value = userNameValue;
			document.getElementById("storedValueInput").textContent = userNameValue;
			document.getElementById("idToBeDeleted").value = idValue;
		}/**
 * 
 */