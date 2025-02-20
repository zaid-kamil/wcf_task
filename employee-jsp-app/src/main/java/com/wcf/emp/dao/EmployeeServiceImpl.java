package com.wcf.emp.dao;

import java.sql.SQLException;
import java.util.List;

import com.wcf.emp.model.EmployeeModel;
import com.wcf.emp.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDao dao;
	
	public EmployeeServiceImpl() {
		this.dao = new EmployeeDao();
	}
	
	@Override
	public void addEmployee(EmployeeModel emp) throws SQLException {
		dao.addEmployee(emp);
	}

	@Override
	public List<EmployeeModel> getAllEmployee() throws SQLException {
		return dao.findAllEmployee();
	}

}
