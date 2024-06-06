package javapages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.server.ServerEndpoint;

public class EmployeeDao {

	public void service(RegisterUser registerUser) throws ClassNotFoundException, SQLException {
//		PrintWriter out = response.getWriter();
//		String firstName = (String) request.getAttribute("firstname");
//		String lastName = (String) request.getAttribute("lastname");
//		String user = (String) request.getAttribute("username");
//		String pass = (String) request.getAttribute("password");
//		String address = (String) request.getAttribute("address");
//		String emailId = (String) request.getAttribute("emailId");
//		String contact = (String) request.getAttribute("contact");
		
		String firstName = registerUser.getFirstName();
		String lastName = registerUser.getLastName();
		String user = registerUser.getUserName();
		String pass = registerUser.getPassword();
		String address = registerUser.getAddress();
		String emailId = registerUser.getEmail();
		String contact = registerUser.getContact();

		Class.forName("com.mysql.cj.jdbc.Driver");
		
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/registerdatabase", "root", "root");

			PreparedStatement preparedStatement = connection
					.prepareStatement("Insert into register(first_name,last_name,user_name,password,address,email,mobile_number) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setString(3, user);
			preparedStatement.setString(4, pass);
			preparedStatement.setString(5, address);
			preparedStatement.setString(6, emailId);
			preparedStatement.setString(7, contact);

			preparedStatement.executeUpdate();

	}

    public List<Map<String, Object>> getAllRecords(int start, int total) throws SQLException, ClassNotFoundException {
        List<Map<String, Object>> registerList = new ArrayList<>();
        List<Map<String, Object>> registerListAllRecords = new ArrayList<>();
        		Class.forName("com.mysql.cj.jdbc.Driver");
        		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/registerdatabase", "root", "root");
        		PreparedStatement preparedStatementAllRecords = connection.prepareStatement("SELECT * FROM register");
        		ResultSet resultsetAllRecords = preparedStatementAllRecords.executeQuery();
        		while (resultsetAllRecords.next()) {
                    Map<String, Object> row = new HashMap<>();
                    row.put("id", resultsetAllRecords.getString("id"));
                    row.put("firstName", resultsetAllRecords.getString("first_name"));
                    row.put("lastName", resultsetAllRecords.getString("last_name"));
                    row.put("user", resultsetAllRecords.getString("user_name"));
                    row.put("pass", resultsetAllRecords.getString("password"));
                    row.put("address", resultsetAllRecords.getString("address"));
                    row.put("emailId", resultsetAllRecords.getString("email"));
                    row.put("contact", resultsetAllRecords.getString("mobile_number"));
                    registerListAllRecords.add(row);
                }
        		int numberOfRecords = registerListAllRecords.size();
        		System.out.println(registerListAllRecords.size() + " hehe " + numberOfRecords);
        		float partition = Math.round(numberOfRecords/5);
        		
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM register LIMIT "+total+" OFFSET "+(start-1));
             ResultSet resultSet = preparedStatement.executeQuery();

             while (resultSet.next()) {
                 Map<String, Object> row = new HashMap<>();
                 row.put("id", resultSet.getString("id"));
                 row.put("firstName", resultSet.getString("first_name"));
                 row.put("lastName", resultSet.getString("last_name"));
                 row.put("user", resultSet.getString("user_name"));
                 row.put("pass", resultSet.getString("password"));
                 row.put("address", resultSet.getString("address"));
                 row.put("emailId", resultSet.getString("email"));
                 row.put("contact", resultSet.getString("mobile_number"));
                 registerList.add(row);
             }
             
        System.out.println(registerList);
        return registerList;
    }

    public static Map<String, Object> getUserByUserName(String user) throws ClassNotFoundException, SQLException{
    		String firstName,lastName,userName,pass,address,emailId,contact;
    		String userNameToBeChanged;
    		Map<String, Object> updateRow = new HashMap<>();
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/registerdatabase", "root", "root");
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM register WHERE user_name=?");
    		preparedStatement.setString(1,user);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		 while (resultSet.next()) { 
    			  firstName = resultSet.getString(2);
    			  lastName = resultSet.getString(3);
    			  userName = resultSet.getString(4);
    			  userNameToBeChanged = resultSet.getString(4);
    			  pass = resultSet.getString(5);
    			  address = resultSet.getString(6);
    			  emailId = resultSet.getString(7);
    			  contact = resultSet.getString(8);
    			  updateRow.put("id", resultSet.getString(1));
    			  updateRow.put("firstName", resultSet.getString(2));
    			  updateRow.put("lastName", resultSet.getString(3));
    			  updateRow.put("user", resultSet.getString(4));
    			  updateRow.put("pass", resultSet.getString(5));
    			  updateRow.put("address", resultSet.getString(6));
    			  updateRow.put("emailId", resultSet.getString(7));
    			  updateRow.put("contact", resultSet.getString(8));
    			  System.out.println("THis is the row we got" + updateRow + " and " + firstName);
             } 
            System.out.println("THis is the row we got" + updateRow);
            return updateRow;
    }  

	public void updateUser(RegisterUser registerUser)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		System.out.println("This is edited " + registerUser.getFirstName());
		String firstname = registerUser.getFirstName();
		String lastname = registerUser.getLastName();
		String address = registerUser.getAddress();
		String pass = registerUser.getPassword();
		String contact = registerUser.getContact();
		String emailId = registerUser.getEmail();
		String user = registerUser.getUserName();
		int id = registerUser.getId();

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdatabase", "root",
				"root");

		String query = "UPDATE register SET first_name=?, last_name=?, address=?, password=?, mobile_number=?, email=?, user_name=? WHERE id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, firstname);
		preparedStatement.setString(2, lastname);
		preparedStatement.setString(3, address);
		preparedStatement.setString(4, pass);
		preparedStatement.setString(5, contact);
		preparedStatement.setString(6, emailId);
		preparedStatement.setString(7, user);
		preparedStatement.setInt(8, id);
		preparedStatement.executeUpdate();
	}
	public void displayView(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	out.println(
			"<h3 style=\"color: red; text-align: center;\">Contact number should have atleast 10 and atmax 12 digits.</h3>");
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/EmployeeRegistration.jsp");
	requestDispatcher.include(request, response);
	}

	public void deleteUser(String user) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/registerdatabase", "root", "root");
		PreparedStatement preparedStatement = connection.prepareStatement("Delete FROM register WHERE user_name=?");
		preparedStatement.setString(1,user);
		preparedStatement.executeUpdate();
		System.out.println("THis use has been deleted: " + user);
	}
	

}
