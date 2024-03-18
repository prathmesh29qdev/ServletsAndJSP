package javapages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/employeeDao")
public class EmployeeDao extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String firstName = (String) request.getAttribute("firstname");
		String lastName = (String) request.getAttribute("lastname");
		String user = (String) request.getAttribute("username");
		String pass = (String) request.getAttribute("password");
		String address = (String) request.getAttribute("address");
		String contact = (String) request.getAttribute("contact");
		int number = 0;
		if (contact != null && !contact.isEmpty()) {
			number = Integer.parseInt(contact);
		}

		if (firstName == "") {
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
				Class.forName("com.mysql.cj.jdbc.Driver");
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdatabase",
							"root", "root");

					PreparedStatement preparedStatement = connection
							.prepareStatement("Insert into register values(?,?,?,?,?,?)");
					preparedStatement.setString(1, firstName);
					preparedStatement.setString(2, lastName);
					preparedStatement.setString(3, user);
					preparedStatement.setString(4, pass);
					preparedStatement.setString(5, address);
					preparedStatement.setInt(6, number);

					int count = preparedStatement.executeUpdate();
					if (count > 0 && !firstName.isEmpty() && !pass.isEmpty() && !user.isEmpty()) {
						response.setContentType("text/html");
						out.println("<h3 style = 'color : green'> User Registration Successful </h3>");
						RequestDispatcher requestDispatcher = request
								.getRequestDispatcher("/RegistrationSuccessful.jsp");
						requestDispatcher.include(request, response);
					} else {
						response.setContentType("text/html");
						out.println("<h3 style = 'color : red'> User Registration Failed </h3>");
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
						requestDispatcher.include(request, response);
					}
				} catch (SQLException e) {
					response.setContentType("text/html");
					out.println("<h3 style = 'color : red'> User Registration Failed - SQL Exception : </h3>"
							+ e.getMessage());
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
					requestDispatcher.include(request, response);
				}
			} catch (ClassNotFoundException e) {
				response.setContentType("text/html");
				out.println("<h3 style = 'color : red'> User Registration Failed - Exception : </h3>" + e.getMessage());
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
				requestDispatcher.include(request, response);
			}
		}
	}

}
