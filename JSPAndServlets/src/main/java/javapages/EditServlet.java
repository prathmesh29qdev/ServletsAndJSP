package javapages;

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

@WebServlet("/editServlet")
public class EditServlet extends HttpServlet{
	
	private EmployeeDao employeeDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String user=request.getParameter("user");    
	        response.setContentType("text/html"); 
	          
	        try {
				Map<String, Object> editRow  = employeeDao.getUserByUserName(user);
				request.setAttribute("editRow", editRow);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
				requestDispatcher.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	}

}
