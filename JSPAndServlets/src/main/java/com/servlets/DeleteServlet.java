package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import com.service.EmployeeService;
import com.service.impl.EmployeeServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <h3>Delete Success</h3>
 * <p>
 * This class performs the deletion and redirects to a delete success page.
 * </p>
 * 
 * @author Prathmesh
 */
@WebServlet("/deleteservlet")
public class DeleteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userName = request.getParameter("storedValue");
			String idToBeDeleted = request.getParameter("idToBeDeleted");
			EmployeeService employeeServiceImpl = new EmployeeServiceImpl();
			employeeServiceImpl.deleteUser(idToBeDeleted);
			response.setContentType("text/html");
			request.setAttribute("deletedUser", userName);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showallrecords?");
			requestDispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}