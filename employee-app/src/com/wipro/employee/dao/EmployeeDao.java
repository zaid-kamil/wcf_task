package com.wipro.employee.dao;

import static com.wipro.employee.utils.DBUtils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wipro.employee.beans.EmployeeBean;
import com.wipro.employee.utils.DBUtils;

public class EmployeeDao {

	private Connection con;

	public EmployeeDao() {
		con = DBUtils.getConnection();
	}

	public String addEmployee(EmployeeBean employee) {
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
		} catch (SQLException e) {
			System.err.println("⚠️⚠️ " + e.getMessage());
			return "Failure";
		}

	}

	public int generateEmployeeId() {
		int id = 0;
		String getLastQuery = "select eid_seq.nextval from dual";
		try (PreparedStatement pst = con.prepareStatement(getLastQuery)) {
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.err.println("⚠️⚠️ " + e.getMessage());
		}
		return id;
	}

	public List<EmployeeBean> findAllEmployee() {
		List<EmployeeBean> employees = new ArrayList<EmployeeBean>();
		try (Statement st = con.createStatement()) {
			String query = "SELECT * FROM employee ORDER BY dept";
			try (ResultSet rs = st.executeQuery(query)) {
				while (rs.next()) {
					employees.add(new EmployeeBean(rs.getInt("id"), rs.getString("name"), rs.getString("email"),
							rs.getString("dept")));
				}
				return employees;
			} catch (SQLException e) {
				System.out.println("⚠️⚠️⚠️ " + e.getMessage());
			}
		} catch (SQLException e) {
			System.out.println("⚠️⚠️ " + e.getMessage());
		}
		return employees;
	}

	public long deleteEmpById(int id) {
		int deletedRows = -1;
		String query = "DELETE FROM " + EMPLOYEE_TBL + " WHERE " + EMP_COL_ID + " = ?";
		try (PreparedStatement pst = con.prepareStatement(query)) {
			pst.setInt(1, id);
			deletedRows = pst.executeUpdate();
		} catch (SQLException e) {
			System.err.println("⚠️⚠️ " + e.getMessage());
		}
		return deletedRows;
	}
}
