

package com.wipro.participant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wipro.participant.bean.ParticipantBean;
import com.wipro.participant.util.DBUtil;

public class ParticipantDAO {

	public String generateId(String studentname) {
		String id = "";
		Connection con = DBUtil.getDBConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT PARTICIPANTID_SEQ.NEXTVAL FROM DUAL");
			rs.next();
			int seq = rs.getInt(1);
			id = studentname.substring(studentname.length() - 2).toUpperCase() + seq;
			System.out.println("ID generated");
		} catch (SQLException e) {
			System.out.println("generateId ->"+e.toString());
			e.printStackTrace();
		}
		System.out.println("ID generated=>"+id);
		return id;
	}

	public String createParticipant(ParticipantBean bean) {
		String result = "";
		Connection con = DBUtil.getDBConnection();
		try{
			PreparedStatement ps = con.prepareStatement("INSERT INTO PARTICIPANT_TABLE VALUES(?,?,?,?,?,?,?,?,?)");
			// set all values from the bean
			ps.setString(1, bean.getId());
			ps.setString(2, bean.getName());
			ps.setInt(3, bean.getTheoryMark1());
			ps.setInt(4, bean.getTheoryMark2());
			ps.setInt(5, bean.getPracticalMark1());
			ps.setInt(6, bean.getPracticalMark2());
			ps.setString(7, bean.getSportsQuotaPresent());
			ps.setInt(8, bean.getTotal());
			ps.setString(9, bean.getResult());
			int rows = ps.executeUpdate();
			System.out.println("Added "+rows+" rows in database");
			if(rows > 0) {
				result = "SUCCESS";
			} else {
				result = "FAIL";
			}
		} catch (SQLException e) {
			System.out.println("error in create participant ->"+e.toString());
			e.printStackTrace();
			result = "FAIL";
		}
		return result;
	}

}
