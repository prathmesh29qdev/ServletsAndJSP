package com.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.dao.EmployeeDao;
import com.databaseConnection.DatabaseConnection;
import com.entities.RegisterUser;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * <h3>Show All Records</h3>
 * <p>
 * This class is used to get the data of all the employees and pass to jsp page.
 * </p>
 * 
 * @author Prathmesh
 */
@WebServlet("/showAllRecords")
public class ShowAllRecordsServlet extends HttpServlet {

	private EmployeeDao employeeDao = new EmployeeDao();;

	static DatabaseConnection databaseConnection = new DatabaseConnection();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			loadData(request, response);
		} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			loadData(request, response);
		} catch (ClassNotFoundException | ServletException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void loadData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		try {
			String pageId = request.getParameter("page");
			if (pageId == null) {
				pageId = "1";
			}
			int pageNumber = Integer.parseInt(pageId);
			int total = 5;
			if (pageNumber != 1) {
				pageNumber = pageNumber - 1;
				pageNumber = pageNumber * total + 1;
			}
			List<RegisterUser> registerListAllRecords = employeeDao.getAllRecords(0, 0);
			double numberOfRecords = registerListAllRecords.size();
			int partition = (int) Math.ceil(numberOfRecords / 5);
			request.setAttribute("partition", partition);
			int numberOfRecord = (int) numberOfRecords;
			request.setAttribute("numberOfRecords", numberOfRecord);
			List<RegisterUser> registerList = employeeDao.getAllRecords(pageNumber, total);
			request.setAttribute("registerList", registerList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/showAllRecords.jsp");
			dispatcher.include(request, response);
		} catch (SQLException e) {
			throw new ServletException("Cannot retrieve records from database", e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}