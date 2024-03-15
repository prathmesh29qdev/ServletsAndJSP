package javapages;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		PrintWriter out = response.getWriter();
		
		if(user.equals("admin") && pass.equals("admin")) {
			request.setAttribute("name_key", "Admin");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("profile.jsp");
			requestDispatcher.forward(request, response);
		} else {
			response.setContentType("text/html");
			out.println("<h3 style = 'color : red'> Wrong credentials </h3>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/NewFile.html");
			requestDispatcher.include(request, response);
		}
	}

}
