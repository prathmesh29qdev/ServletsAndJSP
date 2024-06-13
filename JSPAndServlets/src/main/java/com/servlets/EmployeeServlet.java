package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.EmployeeDao;
import com.entities.RegisterUser;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <h3>Employee Servlet</h3>
 * <p>
 * This class is used to save the data for the employees.
 * </p>
 * 
 * @author Prathmesh
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {

	private EmployeeDao employeeDao = new EmployeeDao();
	private RegisterUser registerUser = new RegisterUser();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Boolean isDuplicate = false;
			String emailId = request.getParameter("email");
			String userName = request.getParameter("username");
			String contact = request.getParameter("contact");
			List<RegisterUser> registerList = employeeDao.getAllRecords(0,0);
			if (emailId != null) {
				for (RegisterUser record : registerList) {
					String recordEmail = (String) record.getEmail();
					if (recordEmail != null && recordEmail.equals(emailId)) {
						isDuplicate = true;
						break;
					}
				}
			} else if (userName != null) {
				for (RegisterUser record : registerList) {
					String recordUser = (String) record.getUserName();
					if (recordUser != null && recordUser.equals(userName)) {
						isDuplicate = true;
						break;
					}
				}
			} else {
				for (RegisterUser record : registerList) {
					String recordContact = String.valueOf(record.getContact());
					if (recordContact != null && recordContact.equals(contact)) {
						isDuplicate = true;
						break;
					}
				}
			}

			if (isDuplicate == true) {
				response.getWriter().write("duplicate");
			}
			else {
				response.getWriter().write("notduplicate");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		PrintWriter out = response.getWriter();
		String Id = request.getParameter("id");
		String firstName = request.getParameter("firstname").trim();
		String lastName = request.getParameter("lastname").trim();
		String userName = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		String address = request.getParameter("address").trim();
		String emailId = request.getParameter("emailId").trim();
		String contact = request.getParameter("contact").trim();
		long contactNumber = Long.parseLong(contact);
		try {
			Boolean isDuplicate = false;
			List<RegisterUser> registerList = employeeDao.getAllRecords(0,0);
			if (Id != "" && Id != null) {
				for (RegisterUser record : registerList) {
					String recordId = String.valueOf(record.getId());
					if (recordId != null && recordId.equals(Id)) {
						isDuplicate = true;
						break;
					}
				}
			}
			if (Id != "" && Id != null) {
			id = Integer.parseInt(Id);
			}
			if (contact == null && contact.isEmpty()) {
				response.setContentType("text/html");
				out.println("<h3 style=\"color: red; text-align: center;\">Contact number should have atleast 10 and atmax 12 digits.</h3>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employeeRegistration.jsp");
				requestDispatcher.include(request, response);
			} else if (firstName == "") {
				response.setContentType("text/html");
				out.println("<h3 style=\"color: red; text-align: center;\">First Name should not be empty.</h3>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employeeRegistration.jsp");
				requestDispatcher.include(request, response);
			} else if (userName == "") {
				response.setContentType("text/html");
				out.println("<h3 style=\"color: red; text-align: center;\">Username should not be empty.</h3>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employeeRegistration.jsp");
				requestDispatcher.include(request, response);
			} else if (password == "") {
				response.setContentType("text/html");
				out.println("<h3 style=\"color: red; text-align: center;\">Password should not be empty.</h3>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employeeRegistration.jsp");
				requestDispatcher.include(request, response);
			} else if (contact == null || contact.isEmpty()) {
				response.setContentType("text/html");
				out.print("<h3 style=\"color: red; text-align: center;\">Enter your contact number and it should only contain digits.</h3>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employeeRegistration.jsp");
				requestDispatcher.include(request, response);
			} else {
					try {
						if (Id != null && Id != null) {
							registerUser.setId(id);
						}
						registerUser.setFirstName(firstName);
						registerUser.setLastName(lastName);
						registerUser.setUserName(userName);
						registerUser.setPassword(password);
						registerUser.setAddress(address);
						registerUser.setEmail(emailId);
						registerUser.setContact(contactNumber);

						if (Id != "" && Id != null) {
							request.setAttribute("id", id);
						}
						request.setAttribute("firstname", firstName);
						request.setAttribute("lastname", lastName);
						request.setAttribute("username", userName);
						request.setAttribute("password", password);
						request.setAttribute("address", address);
						request.setAttribute("emailId", emailId);
						request.setAttribute("contact", contact);
						if (isDuplicate == true) {
							employeeDao.updateUser(registerUser);
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/updateSuccessful.jsp");
							requestDispatcher.forward(request, response);
						} else {
							employeeDao.service(registerUser);
							response.setContentType("text/html");
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registrationSuccessful.jsp");
							requestDispatcher.include(request, response);
						}

					} catch (SQLException e) {
						if (e.getMessage() != null) {
							String errorMessage = e.getMessage();
							if (errorMessage.contains("email")) {
								request.setAttribute("emailError", "Email already exists.");
							}
							if (errorMessage.contains("user")) {
								request.setAttribute("userError", "Username already exists.");
							}
							if (errorMessage.contains("mobile")) {
								request.setAttribute("contactError", "Contact number already exists.");
							}
							if (!errorMessage.contains("email") && !errorMessage.contains("user")
									&& !errorMessage.contains("mobile")) {
								response.setContentType("text/html");
								out.println("<h3 style = 'color : red'> User Registration Failed - SQL Exception : </h3>"
										+ e.getMessage());
							}
							if (isDuplicate != true) {
								request.setAttribute("employeeRecords", registerUser);
							} else {
								request.setAttribute("recordToBeEdited", registerUser);
							}
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employeeRegistration.jsp");
							requestDispatcher.include(request, response);
						}
					}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}