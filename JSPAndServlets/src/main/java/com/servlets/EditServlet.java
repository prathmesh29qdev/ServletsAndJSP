package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
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
 * <h3>Edit Servlet</h3>
 * <p>
 * This class is used to load data for specific employee to edit.
 * </p>
 * 
 * @author Prathmesh
 */
@WebServlet("/editServlet")
public class EditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao employeeDao = new EmployeeDao();

		try {
			RegisterUser recordToBeEdited = employeeDao.getUserById(request.getParameter("id"));
			response.setContentType("text/html");
			request.setAttribute("recordToBeEdited", recordToBeEdited);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/employeeRegistration.jsp");
			requestDispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}