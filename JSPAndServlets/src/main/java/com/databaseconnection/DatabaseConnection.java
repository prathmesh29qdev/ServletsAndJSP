package com.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <h3>Database Connection</h3>
 * <p>
 * This class makes the connection with the database.
 * </p>
 * 
 * @author Prathmesh
 */
public class DatabaseConnection {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdatabase", "root", "root");
		return connection;
	}

}