package javapages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet{
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	        String user=request.getParameter("user");    
	        response.setContentType("text/html"); 
	          
	        try {
	        	String user = request.getParameter("storedValue");
	        	System.out.println("THis is value" + user);
	        	EmployeeDao employeeDao = new EmployeeDao();
				employeeDao.deleteUser(user);
				request.setAttribute("user", user);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/DeleteSuccess.jsp");
				requestDispatcher.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	}
}
