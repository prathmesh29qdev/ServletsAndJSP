package javapages;

import java.io.IOException;
import java.io.NotActiveException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jakartaee.commons.lang3.ObjectUtils.Null;

import com.oracle.wls.shaded.org.apache.xpath.operations.Bool;

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

	private EmployeeDao employeeDao;
	private RegisterUser registerUser = new RegisterUser();
	Map<String, Object> rowStill = new HashMap<>();;

	@Override
	public void init() throws ServletException {
		employeeDao = new EmployeeDao(); // Initialize the DAO

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstname").trim();
		String lastName = request.getParameter("lastname").trim();
		String user = request.getParameter("username").trim();
		String pass = request.getParameter("password").trim();
		String address = request.getParameter("address").trim();
		String emailId = request.getParameter("emailId").trim();
		String contact = request.getParameter("contact").trim();

		if (contact == null && contact.isEmpty()) {
			response.setContentType("text/html");
			out.println(
					"<h3 style=\"color: red; text-align: center;\">Contact number should have atleast 10 and atmax 12 digits.</h3>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
			requestDispatcher.include(request, response);
		} else if (firstName == "") {
			response.setContentType("text/html");
			out.println("<h3 style=\"color: red; text-align: center;\">First Name should not be empty.</h3>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
			requestDispatcher.include(request, response);
		} else if (user == "") {
			response.setContentType("text/html");
			out.println("<h3 style=\"color: red; text-align: center;\">Username should not be empty.</h3>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
			requestDispatcher.include(request, response);
		} else if (pass == "") {
			response.setContentType("text/html");
			out.println("<h3 style=\"color: red; text-align: center;\">Password should not be empty.</h3>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
			requestDispatcher.include(request, response);
		} else if (contact == null || contact.isEmpty()) {
			response.setContentType("text/html");
			out.print(
					"<h3 style=\"color: red; text-align: center;\">Enter your contact number and it should only contain digits.</h3>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
			requestDispatcher.include(request, response);
		} else {
			try {

				try {
					registerUser.setFirstName(firstName);
					registerUser.setLastName(lastName);
					registerUser.setUserName(user);
					registerUser.setPassword(pass);
					registerUser.setAddress(address);
					registerUser.setEmail(emailId);
					registerUser.setContact(contact);
					System.out.println("THis is object " + registerUser);

					rowStill.put("firstName", firstName);
					rowStill.put("lastName", lastName);
					rowStill.put("user", user);
					rowStill.put("pass", pass);
					rowStill.put("address", address);
					rowStill.put("emailId", emailId);
					rowStill.put("contact", contact);

					request.setAttribute("firstname", firstName);
					request.setAttribute("lastname", lastName);
					request.setAttribute("username", user);
					request.setAttribute("password", pass);
					request.setAttribute("address", address);
					request.setAttribute("emailId", emailId);
					request.setAttribute("contact", contact);
					employeeDao.service(registerUser);

					response.setContentType("text/html");
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/RegistrationSuccessful.jsp");
					requestDispatcher.include(request, response);

				} catch (SQLException e) {
					System.out.println(e.getMessage());
					if (e.getMessage() != null) {
						String errorMessage = e.getMessage();
						System.out.println(errorMessage);
						System.out.println("email value " + errorMessage.contains("email"));
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
						System.out.println("HEHE " + rowStill);
						request.setAttribute("rowStill", rowStill);
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
						requestDispatcher.include(request, response);
					}
				}
			} catch (Exception e) {
				System.out.println("HEHE " + rowStill);
				request.setAttribute("rowStill", rowStill);
				response.setContentType("text/html");
				out.println(
						"<h3 style=\"color: red; text-align: center;\">Enter a valid number or check if it's correct.</h3>");
				System.out.println("HEHE " + rowStill);
				request.setAttribute("rowStill", rowStill);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
				requestDispatcher.include(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Boolean isDuplicate = false;
			String emailId = request.getParameter("email");
			String userName = request.getParameter("username");
			String contact = request.getParameter("contact");
			List<Map<String, Object>> registerList = employeeDao.getAllRecordsWithoutPagination();
			System.out.println("THIS is the full list "+  emailId + " and " + registerList);

			if (emailId != null) {
				for (Map<String, Object> record : registerList) {
					String recordEmail = (String) record.get("emailId");
					if (recordEmail != null && recordEmail.equals(emailId)) {
						isDuplicate = true;
						break;
					}
				}
			} else if (userName != null) {
				for (Map<String, Object> record : registerList) {
					String recordUser = (String) record.get("user");
					if (recordUser != null && recordUser.equals(userName)) {
						isDuplicate = true;
						break;
					}
				}
			} else {
				for (Map<String, Object> record : registerList) {
					String recordContact = (String) record.get("contact");
					if (recordContact != null && recordContact.equals(contact)) {
						isDuplicate = true;
						break;
					}
				}
			}
			
			if(isDuplicate == true) {
				response.getWriter().write("duplicate");
			}
			else {
				response.getWriter().write("notduplicate");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
