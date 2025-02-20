package com.wipro.employee.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wipro.employee.beans.EmployeeBean;

public class EmployeeDaoTest {
	EmployeeDao dao;

	@Before
	public void setUp() throws Exception {
		dao = new EmployeeDao();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void testFindAllEmployee() throws SQLException {

		List<EmployeeBean> allEmployee = dao.findAllEmployee();
		assertNotEquals(0, allEmployee.size());

	}

}
