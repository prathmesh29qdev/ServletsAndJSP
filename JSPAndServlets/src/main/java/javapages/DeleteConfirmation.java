package javapages;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteConfirmation")
public class DeleteConfirmation extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user=request.getParameter("user");
       
        response.setContentType("text/html"); 
          
        	request.setAttribute("user", user);
        	request.getRequestDispatcher("showAllRecords").include(request, response);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/DeleteConfirmation.jsp");
			requestDispatcher.forward(request, response);
	
}
}
