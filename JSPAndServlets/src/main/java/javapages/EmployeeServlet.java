package javapages;

import java.io.IOException;
import java.io.NotActiveException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.tomcat.jakartaee.commons.lang3.ObjectUtils.Null;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String address = request.getParameter("address");
		int number = Integer.parseInt(request.getParameter("contact"));
		
		request.setAttribute("firstname", firstName);
		request.setAttribute("lastname", lastName);
		request.setAttribute("username", user);
		request.setAttribute("password", pass);
		request.setAttribute("address", address);
		request.setAttribute("contact", number);
		request.getRequestDispatcher("employeeDao").forward(request, response);

//		if (firstName == "") {
//			response.setContentType("text/html");
//			out.println("<h5>First Name should not be empty.</h5>");
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
//			requestDispatcher.include(request, response);
//		} else if (user == "") {
//			response.setContentType("text/html");
//			out.println("<h5>Username should not be empty.</h5>");
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
//			requestDispatcher.include(request, response);
//		} else if (pass == "") {
//			response.setContentType("text/html");
//			out.println("<h5>Password should not be empty.</h5>");
//			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
//			requestDispatcher.include(request, response);
//		} else {
//			try {
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				try {
//					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdatabase", "root", "root");
//
//					PreparedStatement preparedStatement = connection.prepareStatement("Insert into register values(?,?,?,?,?,?)");
//					preparedStatement.setString(1, firstName);
//					preparedStatement.setString(2, lastName);
//					preparedStatement.setString(3, user);
//					preparedStatement.setString(4, pass);
//					preparedStatement.setString(5, address);
//					preparedStatement.setInt(6, number);
//
//					int count = preparedStatement.executeUpdate();
//					if(count > 0 && !firstName.isEmpty() && !pass.isEmpty() && !user.isEmpty()) {
//						response.setContentType("text/html");
//						out.println("<h3 style = 'color : green'> User Registration Successful </h3>");
//						RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
//						requestDispatcher.include(request, response);
//					} else {
//						response.setContentType("text/html");
//						out.println("<h3 style = 'color : red'> User Registration Failed </h3>");
//						RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
//						requestDispatcher.include(request, response);
//					}
//				} catch (SQLException e) {
//					response.setContentType("text/html");
//					out.println("<h3 style = 'color : red'> User Registration Failed - SQL Exception : </h3>" + e.getMessage());
//					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
//					requestDispatcher.include(request, response);
//				}
//			} catch (ClassNotFoundException e) {
//				response.setContentType("text/html");
//				out.println("<h3 style = 'color : red'> User Registration Failed - Exception : </h3>" + e.getMessage());
//				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
//				requestDispatcher.include(request, response);
//			}
//		}
	}

}
