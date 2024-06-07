package javapages.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javapages.dao.EmployeeDao;

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
		String user = request.getParameter("user");

		try {
			Map<String, Object> editRow = employeeDao.getUserByUserName(user);
			response.setContentType("text/html");
			request.setAttribute("editRow", editRow);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
			requestDispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}