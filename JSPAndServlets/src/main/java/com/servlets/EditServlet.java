package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import com.entity.RegisterUser;
import com.service.EmployeeService;
import com.service.impl.EmployeeServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <h3>Edit Servlet</h3>
 * <p>
 * This class is used to load data for specific employee to edit.
 * </p>
 * 
 * @author Prathmesh
 */
@WebServlet("/editservlet")
public class EditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeService employeeServiceImpl = new EmployeeServiceImpl();

		try {
			RegisterUser recordToBeEdited = employeeServiceImpl.getUserById(request.getParameter("id"));
			response.setContentType("text/html");
			request.setAttribute("recordToBeEdited", recordToBeEdited);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employeeregistration.jsp");
			requestDispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}