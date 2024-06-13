package com.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import com.entity.RegisterUser;
import jakarta.servlet.ServletException;

public interface EmployeeService {

	public void service(RegisterUser registerUser) throws ClassNotFoundException, SQLException;

	public List<RegisterUser> getAllRecords(int start, int total) throws SQLException, ClassNotFoundException;

	public RegisterUser getUserById(String id) throws ClassNotFoundException, SQLException;

	public void updateUser(RegisterUser registerUser) throws ServletException, IOException, ClassNotFoundException, SQLException;

	public void deleteUser(String idToBeDeleted) throws ClassNotFoundException, SQLException;

}