package com.wcf.emp.service;

import java.sql.SQLException;
import java.util.List;

import com.wcf.emp.model.EmployeeModel;

public interface EmployeeService {
	void addEmployee(EmployeeModel emp) throws SQLException;
	List<EmployeeModel> getAllEmployee() throws SQLException;
}
