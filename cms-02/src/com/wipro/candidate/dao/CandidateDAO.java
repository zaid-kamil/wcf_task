package com.wipro.candidate.dao;

import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class CandidateDAO {

	Connection con;

	public String addCandidate(CandidateBean studentBean) {
		String status = "";
		if (studentBean == null) {
			status = "FAIL";
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
		} catch (SQLException e) {
			status = "FAIL";
		}
		return status;
	}

	public ArrayList<CandidateBean> getByResult(String criteria) {
		ArrayList<CandidateBean> list = new ArrayList<CandidateBean>();
		con = DBUtil.getDBConn();
		String query;
		if (criteria.equalsIgnoreCase("ALL")) {
			query = "SELECT * FROM CANDIDATE_TBL";
		} else {
			query = "SELECT * FROM CANDIDATE_TBL WHERE result LIKE ?";
		}
		try {
			PreparedStatement pst = con.prepareStatement(query);
			if (!criteria.equalsIgnoreCase("ALL"))
				pst.setString(1, criteria);
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
			return null;
		}
		System.out.println(list);
		return list;
	}

	public String generateCandidateId(String name) {
		String id = "";
		try {
			con = DBUtil.getDBConn();
			String query = "SELECT CANDID_SEQ.NEXTVAL FROM dual";
			PreparedStatement pst = con.prepareStatement(query);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					id = name.substring(0, 2) + rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			return "FA" + new Random().nextInt(5000);
		}
		return id;
	}
}
