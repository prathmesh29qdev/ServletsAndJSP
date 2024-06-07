package javapages.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javapages.dao.EmployeeDao;
import javapages.entities.RegisterUser;

/**
 * <h3>Update Servlet</h3>
 * <p>
 * This class is used to get the updates values and store into database.
 * </p>
 * 
 * @author Prathmesh
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	Map<String, Object> employeeRecords = new HashMap<>();;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException {
		PrintWriter out = response.getWriter();
		String firstName = request.getParameter("firstname").trim();
		String lastName = request.getParameter("lastname").trim();
		String user = request.getParameter("username").trim();
		String pass = request.getParameter("password").trim();
		String address = request.getParameter("address").trim();
		String emailId = request.getParameter("emailId").trim();
		String number = request.getParameter("contact").trim();
		String Id = request.getParameter("id").trim();
		int id = Integer.parseInt(Id);

		if (number == null && number.isEmpty()) {
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
		} else if (number == null || number.isEmpty()) {
			response.setContentType("text/html");
			out.print(
					"<h3 style=\"color: red; text-align: center;\">Enter your contact number and it should only contain digits.</h3>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
			requestDispatcher.include(request, response);
		} else {
			request.setAttribute("id", id);
			request.setAttribute("firstname", firstName);
			request.setAttribute("lastname", lastName);
			request.setAttribute("username", user);
			request.setAttribute("password", pass);
			request.setAttribute("address", address);
			request.setAttribute("emailId", emailId);
			request.setAttribute("contact", number);

			employeeRecords.put("id", id);
			employeeRecords.put("firstName", firstName);
			employeeRecords.put("lastName", lastName);
			employeeRecords.put("user", user);
			employeeRecords.put("pass", pass);
			employeeRecords.put("address", address);
			employeeRecords.put("emailId", emailId);
			employeeRecords.put("contact", number);

			RegisterUser registerUser = new RegisterUser();
			registerUser.setId(id);
			registerUser.setFirstName(firstName);
			registerUser.setLastName(lastName);
			registerUser.setUserName(user);
			registerUser.setPassword(pass);
			registerUser.setAddress(address);
			registerUser.setEmail(emailId);
			registerUser.setContact(number);
			EmployeeDao employeeDao = new EmployeeDao();
			try {
				employeeDao.updateUser(registerUser);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/updateSuccessful.jsp");
				requestDispatcher.forward(request, response);

			} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
				System.out.println(e.getMessage());
				request.setAttribute("editedRow", employeeRecords);
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
						out.println("<h3 style = 'color : red'> User Registration Failed - SQL Exception : </h3>" + e.getMessage());
					}
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
					requestDispatcher.include(request, response);
				}
			}
		}
	}

}