package com.wipro.bank.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.util.DBUtil;

public class BankDAO {

	public boolean validateAccount(String accountNumber) throws SQLException {
		boolean validAccountStatus = false;
		String query = "SELECT * FROM ACCOUNT_TBL WHERE Account_Number = ?";
		Connection con = DBUtil.getDBConnection();
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, accountNumber);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			validAccountStatus = true;
		}
		con.close();
		return validAccountStatus;
	}

	public float findBalance(String accountNumber) {
		float balance = 0f;
		try {
			if (validateAccount(accountNumber)) {
				String query = "SELECT Balance FROM ACCOUNT_TBL WHERE Account_Number = ?";
				Connection con = DBUtil.getDBConnection();
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, accountNumber);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					balance = rs.getFloat(1);
				}
				con.close();
			}else{
				balance = -1;
			}
		} catch (SQLException e) {
			System.out.println(e);
			balance = -1;
		}
		return balance;
	}

	public boolean updateBalance(String accountNumber, float newBalance) {
		boolean status = false;
		try {
			String updateQuery = "UPDATE ACCOUNT_TBL SET Balance = ? WHERE Account_Number = ?";
			Connection con = DBUtil.getDBConnection();
			PreparedStatement ps = con.prepareStatement(updateQuery);
			ps.setFloat(1, newBalance);
			ps.setString(2, accountNumber);
			int rows = ps.executeUpdate();
			if (rows > 0) {
				status = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return status;
	}

	public boolean transferMoney(TransferBean transferBean) {
		boolean transferStatus = false;
		try {
			String insertQuery = "INSERT INTO TRANSFER_TBL VALUES(?, ?, ?, ?, ?)";
			PreparedStatement ps = DBUtil.getDBConnection().prepareStatement(insertQuery);
			ps.setInt(1, transferBean.getTransactionID());
			ps.setString(2, transferBean.getFromAccountNumber());
			ps.setString(3, transferBean.getToAccountNumber());
			ps.setDate(4, new Date(transferBean.getDateOfTransaction().getTime()));
			ps.setFloat(5, transferBean.getAmount());
			int rows = ps.executeUpdate();
			if (rows > 0) {
				transferStatus = true;
			}
			ps.getConnection().close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return transferStatus;
	}

	public int generateSequenceNumber() {
		try {
			Connection con = DBUtil.getDBConnection();
			String query = "SELECT transactionId_seq.nextval FROM DUAL";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {	
			return new Random().nextInt(5000,9000);
		}
		return -1;
	}

}
