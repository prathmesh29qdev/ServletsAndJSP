package com.service.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.databaseconnection.DatabaseConnection;
import com.entity.RegisterUser;
import com.service.EmployeeService;

import jakarta.servlet.ServletException;

/**
 * <h3>Employee Dao</h3>
 * <p>
 * This class is used to perform operations on database.
 * </p>
 * 
 * @author Prathmesh
 */
public class EmployeeServiceImpl implements EmployeeService {

	static DatabaseConnection databaseConnection = new DatabaseConnection();

	public void service(RegisterUser registerUser) throws ClassNotFoundException, SQLException {
		Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("Insert into register(first_name, last_name, user_name, password, address, email, mobile_number) values(?, ?, ?, ?, ?, ?, ?)");
		preparedStatement.setString(1, registerUser.getFirstName());
		preparedStatement.setString(2, registerUser.getLastName());
		preparedStatement.setString(3, registerUser.getUserName());
		preparedStatement.setString(4, registerUser.getPassword());
		preparedStatement.setString(5, registerUser.getAddress());
		preparedStatement.setString(6, registerUser.getEmail());
		preparedStatement.setLong(7, registerUser.getContact());
		preparedStatement.executeUpdate();
		connection.close();
	}

	public List<RegisterUser> getAllRecords(int start, int total) throws SQLException, ClassNotFoundException {
		Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatementAllRecords = connection.prepareStatement("SELECT * FROM register");
		ResultSet resultsetAllRecords = preparedStatementAllRecords.executeQuery();
		List<RegisterUser> registerUsers = new ArrayList<RegisterUser>();
		List<RegisterUser> registerUsersListToBeReturned = new ArrayList<RegisterUser>();
		while (resultsetAllRecords.next()) {
			RegisterUser registerUser = new RegisterUser();
			registerUser.setId(resultsetAllRecords.getInt("id"));
			registerUser.setFirstName(resultsetAllRecords.getString("first_name"));
			registerUser.setLastName(resultsetAllRecords.getString("last_name"));
			registerUser.setUserName(resultsetAllRecords.getString("user_name"));
			registerUser.setPassword(resultsetAllRecords.getString("password"));
			registerUser.setAddress(resultsetAllRecords.getString("address"));
			registerUser.setEmail(resultsetAllRecords.getString("email"));
			registerUser.setContact(resultsetAllRecords.getLong("mobile_number"));
			registerUsers.add(registerUser);
		}
		if (start != 0 && total != 0) {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM register LIMIT " + total + " OFFSET " + (start - 1));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				RegisterUser registerUser = new RegisterUser();
				registerUser.setId(Integer.parseInt(resultSet.getString("id")));
				registerUser.setFirstName(resultSet.getString("first_name"));
				registerUser.setLastName(resultSet.getString("last_name"));
				registerUser.setUserName(resultSet.getString("user_name"));
				registerUser.setPassword(resultSet.getString("password"));
				registerUser.setAddress(resultSet.getString("address"));
				registerUser.setEmail(resultSet.getString("email"));
				registerUser.setContact(resultSet.getLong("mobile_number"));
				registerUsersListToBeReturned.add(registerUser);
			}
			connection.close();
			return registerUsersListToBeReturned;
		} else {
			connection.close();
			return registerUsers;
		}
	}

	public RegisterUser getUserById(String id) throws ClassNotFoundException, SQLException {
		RegisterUser registerUser = new RegisterUser();
		Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM register WHERE id=?");
		preparedStatement.setString(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			registerUser.setId(resultSet.getInt("id"));
			registerUser.setFirstName(resultSet.getString("first_name"));
			registerUser.setLastName(resultSet.getString("last_name"));
			registerUser.setUserName(resultSet.getString("user_name"));
			registerUser.setPassword(resultSet.getString("password"));
			registerUser.setAddress(resultSet.getString("address"));
			registerUser.setEmail(resultSet.getString("email"));
			registerUser.setContact(resultSet.getLong("mobile_number"));
		}
		connection.close();
		return registerUser;
	}

	public void updateUser(RegisterUser registerUser) throws ServletException, IOException, ClassNotFoundException, SQLException {
		Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE register SET first_name=?, last_name=?, address=?, password=?, mobile_number=?, email=?, user_name=? WHERE id=?");
		preparedStatement.setString(1, registerUser.getFirstName());
		preparedStatement.setString(2, registerUser.getLastName());
		preparedStatement.setString(3, registerUser.getAddress());
		preparedStatement.setString(4, registerUser.getPassword());
		preparedStatement.setLong(5, registerUser.getContact());
		preparedStatement.setString(6, registerUser.getEmail());
		preparedStatement.setString(7, registerUser.getUserName());
		preparedStatement.setInt(8, registerUser.getId());
		preparedStatement.executeUpdate();
		connection.close();
	}

	public void deleteUser(String idToBeDeleted) throws ClassNotFoundException, SQLException {
		Connection connection = databaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("Delete FROM register WHERE id=?");
		preparedStatement.setString(1, idToBeDeleted);
		preparedStatement.executeUpdate();
		connection.close();
	}

}