package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import com.dao.EmployeeDao;

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
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userName = request.getParameter("storedValue");
			String idToBeDeleted = request.getParameter("idToBeDeleted");
			EmployeeDao employeeDao = new EmployeeDao();
			employeeDao.deleteUser(idToBeDeleted);
			response.setContentType("text/html");
			request.setAttribute("deletedUser", userName);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showAllRecords?");
			requestDispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}