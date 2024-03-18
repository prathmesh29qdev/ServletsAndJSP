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
public class EmployeeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		PrintWriter out = response.getWriter();

		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String address = request.getParameter("address");
		String number = request.getParameter("contact");

		request.setAttribute("firstname", firstName);
		request.setAttribute("lastname", lastName);
		request.setAttribute("username", user);
		request.setAttribute("password", pass);
		request.setAttribute("address", address);
		request.setAttribute("contact", number);
		request.getRequestDispatcher("employeeDao").forward(request, response);
	}

}
