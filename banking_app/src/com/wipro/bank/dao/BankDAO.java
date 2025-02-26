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

    public boolean validateAccount(String accountNumber) {
        boolean validAccountStatus = false;
        String query = "SELECT count(*) FROM ACCOUNT_TBL WHERE Account_Number = ?";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, accountNumber);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    validAccountStatus = true;
                }
            }
            System.out.println("account number is:" + accountNumber + " status = " + validAccountStatus);
        } catch (SQLException e) {
            System.out.print(accountNumber + "-->" + e.getMessage());
        }
        return validAccountStatus;
    }

    public float findBalance(String accountNumber) throws SQLException {
        float balance = 0f;
        if (validateAccount(accountNumber)) {
            String query = "SELECT Balance FROM ACCOUNT_TBL WHERE Account_Number = ?";
            try (Connection con = DBUtil.getDBConnection();
                 PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, accountNumber);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        balance = rs.getFloat(1);
                    }
                }
            }
        } else {
            System.out.println("Balance not found for " + accountNumber);
            balance = -1;
        }
        return balance;
    }

    public boolean updateBalance(String accountNumber, float newBalance) {
        boolean status = false;
        String updateQuery = "UPDATE ACCOUNT_TBL SET Balance = ? WHERE Account_Number = ?";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(updateQuery)) {
            ps.setFloat(1, newBalance);
            ps.setString(2, accountNumber);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                status = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    public boolean transferMoney(TransferBean transferBean) {
        boolean transferStatus = false;
        String insertQuery = "INSERT INTO TRANSFER_TBL VALUES(?, ?, ?, ?, ?)";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(insertQuery)) {
            ps.setInt(1, transferBean.getTransactionID());
            ps.setString(2, transferBean.getFromAccountNumber());
            ps.setString(3, transferBean.getToAccountNumber());
            ps.setDate(4, new Date(transferBean.getDateOfTransaction().getTime()));
            ps.setFloat(5, transferBean.getAmount());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                transferStatus = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return transferStatus;
    }

    public int generateSequenceNumber() {
        int id = 0000;
        String query = "SELECT transactionId_seq.nextval FROM DUAL";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		System.out.println("Generated sequence number: " + id);
        return id;
    }
}
