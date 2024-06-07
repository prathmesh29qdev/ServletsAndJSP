package javapages.servlets;

import java.io.IOException;
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
			String user = request.getParameter("storedValue");
			System.out.println("THis is value" + user);
			EmployeeDao employeeDao = new EmployeeDao();
			employeeDao.deleteUser(user);
			response.setContentType("text/html");
			request.setAttribute("deletedUser", user);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/showAllRecords?");
			requestDispatcher.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}