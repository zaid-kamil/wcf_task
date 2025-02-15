package com.wipro.candidate.dao;

import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class CandidateDAO {

	Connection con;

	public String addCandidate(CandidateBean studentBean) {
		String status = "FAIL";
		if (studentBean == null) {
			System.err.println("Student bean is null, Cannot add student!");
			return status;
		}
		con = DBUtil.getDBConn();
		String insertQuery = "INSERT INTO CANDIDATE_TBL (ID, Name, M1, M2, M3, Result, Grade) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(insertQuery);
			pst.setString(1, studentBean.getId());
			pst.setString(2, studentBean.getName());
			pst.setInt(3, studentBean.getM1());
			pst.setInt(4, studentBean.getM2());
			pst.setInt(5, studentBean.getM3());
			pst.setString(6, studentBean.getResult());
			pst.setString(7, studentBean.getGrade());
			int rows = pst.executeUpdate();
			if (rows > 0) {
				status = "SUCCESS";
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			System.err.println("Duplicate entry while adding candidate!");
		} catch (SQLException e1) {
			System.err.println("SQL exception, can't add data: " + e1.getMessage());
		}
		return status;
	}

	public ArrayList<CandidateBean> getByResult(String criteria) {
		ArrayList<CandidateBean> list = new ArrayList<CandidateBean>();
		con = DBUtil.getDBConn();
		String query = switch (criteria) {
		case "ALL":
			yield "SELECT * FROM CANDIDATE_TBL";
		default:
			yield "SELECT * FROM CANDIDATE_TBL WHERE result LIKE " + criteria;
		};
		try {
			PreparedStatement pst = con.prepareStatement(query);
			try (ResultSet rs = pst.executeQuery()) {

				while (rs.next()) {
					CandidateBean cb = new CandidateBean();
					cb.setId(rs.getString(1));
					cb.setName(rs.getString(2));
					cb.setM1(rs.getInt(3));
					cb.setM2(rs.getInt(4));
					cb.setM3(rs.getInt(5));
					cb.setResult(rs.getString(6));
					cb.setGrade(rs.getString(7));
					list.add(cb);
				}
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
		return list;
	}

	public String generateCandidateId(String name) throws SQLException {
		String id = "";
		con = DBUtil.getDBConn();
		String query = "SELECT CANDID_SEQ.NEXTVAL FROM dual";
		PreparedStatement pst = con.prepareStatement(query);
		try (ResultSet rs = pst.executeQuery()) {
			if (rs.next()) {
				id = name.substring(0, 2) + rs.getInt(1);
			}
		}
		return id;
	}
}
