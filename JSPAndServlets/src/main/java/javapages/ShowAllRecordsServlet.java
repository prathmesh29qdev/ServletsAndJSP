package javapages;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/showAllRecords")
public class ShowAllRecordsServlet extends HttpServlet{

	private EmployeeDao employeeDao; 
	@Override
	public void init() throws ServletException {
		employeeDao = new EmployeeDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        loadData(request, response);
	}
	
	protected void loadData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Map<String, Object>> registerListAllRecords = new ArrayList<>();
		try {
			String pageId = request.getParameter("page");
			if (pageId == null) {
				pageId = "1";
			}
			int pageNumber = Integer.parseInt(pageId);
			int total = 5;
			if(pageNumber==1){}  
		    else{  
		       	pageNumber=pageNumber-1;  
		       	pageNumber=pageNumber*total+1;  
		    } 
			Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/registerdatabase", "root", "root");
    		PreparedStatement preparedStatementAllRecords = connection.prepareStatement("SELECT * FROM register");
    		ResultSet resultsetAllRecords = preparedStatementAllRecords.executeQuery();
    		while (resultsetAllRecords.next()) {
                Map<String, Object> row = new HashMap<>();
                row.put("firstName", resultsetAllRecords.getString("first_name"));
                row.put("lastName", resultsetAllRecords.getString("last_name"));
                row.put("user", resultsetAllRecords.getString("user_name"));
                row.put("pass", resultsetAllRecords.getString("password"));
                row.put("address", resultsetAllRecords.getString("address"));
                row.put("emailId", resultsetAllRecords.getString("email"));
                row.put("contact", resultsetAllRecords.getString("mobile_number"));
                registerListAllRecords.add(row);
            }
    		double numberOfRecords = registerListAllRecords.size();
    		int partition = (int) Math.ceil(numberOfRecords/5);
    		System.out.println(registerListAllRecords.size() + " hehe " + numberOfRecords + " " + partition);
    		request.setAttribute("partition", partition);
    		int numberOfRecord = (int) numberOfRecords;
    		request.setAttribute("numberOfRecords", numberOfRecord);
    		
			List<Map<String, Object>> registerList = employeeDao.getAllRecords(pageNumber,total);
			request.setAttribute("registerList", registerList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ShowAllRecords.jsp");
			dispatcher.include(request, response);
		} catch (SQLException e) {
			throw new ServletException("Cannot retrieve records from database", e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
