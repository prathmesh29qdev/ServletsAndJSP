package javapages;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.connector.Response;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mysearch = request.getParameter("search1");
		
		response.sendRedirect("https://www.google.com/search?q=" + mysearch);
		
//		int number2 = Integer.parseInt(request.getParameter("number2"));
//		int addition = number1 + number2;
//		int multiply = number1 * number2;
		
//		PrintWriter out = response.getWriter();
//		out.println("Hello " + addition);
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("square");
//		requestDispatcher.forward(request, response);
	}
	
}