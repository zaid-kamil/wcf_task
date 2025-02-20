package com.wcf.emp.dao;

import static com.wcf.emp.config.JdbcConfig.EMPLOYEE_TBL;
import static com.wcf.emp.config.JdbcConfig.EMP_COL_ID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wcf.emp.config.JdbcConfig;
import com.wcf.emp.exception.EmployeeNotFoundException;
import com.wcf.emp.model.EmployeeModel;

public class EmployeeDao {

	private Connection con;

	public EmployeeDao() {
		con = JdbcConfig.getConnection();
	}

	public String addEmployee(EmployeeModel employee) throws SQLException {
		int newId = generateEmployeeId();
		String insertQuery = "INSERT INTO " + EMPLOYEE_TBL + " VALUES(?, ?, ?, ?)";
		try (PreparedStatement pst = con.prepareStatement(insertQuery)) {
			pst.setInt(1, newId);
			pst.setString(2, employee.getName());
			pst.setString(3, employee.getEmail());
			pst.setString(4, employee.getDept());
			long insertedRows = pst.executeUpdate();
			System.out.println("🎉 Added " + insertedRows + " Employee successfully 🎉");
			return "Success";
		}

	}

	public int generateEmployeeId() throws SQLException {
		int id = 0;
		String getLastQuery = "select eid_seq.nextval from dual";
		try (PreparedStatement pst = con.prepareStatement(getLastQuery)) {
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		}
		return id;
	}

	public List<EmployeeModel> findAllEmployee() throws SQLException {
		List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
		try (Statement st = con.createStatement()) {
			String query = "SELECT * FROM employee ORDER BY dept";
			try (ResultSet rs = st.executeQuery(query)) {
				while (rs.next()) {
					employees.add(new EmployeeModel(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
							rs.getString("dept")));
				}
				return employees;
			} catch (SQLException e) {
				System.out.println("⚠️⚠️⚠️ " + e.getMessage());
			}
		}
		return employees;
	}

	public long deleteEmpById(int id) throws SQLException {
		int deletedRows = -1;
		String query = "DELETE FROM " + EMPLOYEE_TBL + " WHERE " + EMP_COL_ID + " = ?";
		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setInt(1, id);
			deletedRows = pst.executeUpdate();
		}
		return deletedRows;
	}

	public EmployeeModel searchEmployeeByID(int id) throws EmployeeNotFoundException, SQLException {
		String query = "SELECT * FROM employee WHERE id = ?";
		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (!rs.next()) {
				throw new EmployeeNotFoundException();
			}
			return new EmployeeModel(id, rs.getString("name"), rs.getString("email"), rs.getString("dept"));
		}
	}
}
