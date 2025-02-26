package com.wipro.bank.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Date;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.dao.BankDAO;
import com.wipro.bank.util.InsufficientFundsException;

public class BankMain {
	public static void main(String[] args) {
		BankMain bankMain = new BankMain();

		// view balance
		System.out.println(bankMain.checkBalance("1234567894"));

		// transfer money
		TransferBean transferBean = new TransferBean();

		transferBean.setFromAccountNumber("1234567894");
		transferBean.setToAccountNumber("1234567891");
		transferBean.setAmount(1000);
		transferBean.setDateOfTransaction(new Date());
		System.out.println(bankMain.transfer(transferBean));

		// 1. Test for Balance checking with valid account number
		String checkBalanceValid = bankMain.checkBalance("1234567894");
		System.out.println("Test 1 - Valid Account Balance Check: " + checkBalanceValid);

		// 2. Test for Balance checking with invalid account number
		String checkBalanceInvalid = bankMain.checkBalance("0000000000");
		System.out.println("Test 2 - Invalid Account Balance Check: " + checkBalanceInvalid);

		// 3. Test for successful transfer of funds
		TransferBean transferBeanSuccess = new TransferBean();
		transferBeanSuccess.setFromAccountNumber("1234567894");
		transferBeanSuccess.setToAccountNumber("1234567891");
		transferBeanSuccess.setAmount(1000);
		transferBeanSuccess.setDateOfTransaction(new Date());
		String transferSuccess = bankMain.transfer(transferBeanSuccess);
		System.out.println("Test 3 - Successful Transfer: " + transferSuccess);

		// 4. Test for transfer with low funds
		TransferBean transferBeanLowFunds = new TransferBean();
		transferBeanLowFunds.setFromAccountNumber("1234567894");
		transferBeanLowFunds.setToAccountNumber("1234567891");
		transferBeanLowFunds.setAmount(1000000); // Assuming this is more than the balance
		transferBeanLowFunds.setDateOfTransaction(new Date());
		String transferLowFunds = bankMain.transfer(transferBeanLowFunds);
		System.out.println("Test 4 - Transfer with Low Funds: " + transferLowFunds);

		// 5. Test for transfer with zero balance
		TransferBean transferBeanZeroBalance = new TransferBean();
		transferBeanZeroBalance.setFromAccountNumber("1234567894");
		transferBeanZeroBalance.setToAccountNumber("1234567891");
		transferBeanZeroBalance.setAmount(0);
		transferBeanZeroBalance.setDateOfTransaction(new Date());
		String transferZeroBalance = bankMain.transfer(transferBeanZeroBalance);
		System.out.println("Test 5 - Transfer with Zero Balance: " + transferZeroBalance);

		// 6. Test for transfer with invalid payer account number
		TransferBean transferBeanInvalidPayer = new TransferBean();
		transferBeanInvalidPayer.setFromAccountNumber("0000000000");
		transferBeanInvalidPayer.setToAccountNumber("1234567891");
		transferBeanInvalidPayer.setAmount(1000);
		transferBeanInvalidPayer.setDateOfTransaction(new Date());
		String transferInvalidPayer = bankMain.transfer(transferBeanInvalidPayer);
		System.out.println("Test 6 - Transfer with Invalid Payer Account: " + transferInvalidPayer);

		// 7. Test for transfer with invalid beneficiary account number
		TransferBean transferBeanInvalidBeneficiary = new TransferBean();
		transferBeanInvalidBeneficiary.setFromAccountNumber("1234567894");
		transferBeanInvalidBeneficiary.setToAccountNumber("0000000000");
		transferBeanInvalidBeneficiary.setAmount(1000);
		transferBeanInvalidBeneficiary.setDateOfTransaction(new Date());
		String transferInvalidBeneficiary = bankMain.transfer(transferBeanInvalidBeneficiary);
		System.out.println("Test 7 - Transfer with Invalid Beneficiary Account: " + transferInvalidBeneficiary);

	}

	public String checkBalance(String accountNumber) {
		BankDAO dao = new BankDAO();
		String msg = "ACCOUNT NUMBER INVALID";
		try {
			if (dao.validateAccount(accountNumber)) {
				float balance = dao.findBalance(accountNumber);
				msg = String.format("BALANCE IS:%.2f", balance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msg;
	}

	public String transfer(TransferBean transferBean) {
		BankDAO dao = new BankDAO();
		if (transferBean == null) {
			return "INVALID";
		}

		try {
			if (!dao.validateAccount(transferBean.getToAccountNumber())
					|| !dao.validateAccount(transferBean.getFromAccountNumber())) {
				return "INVALID ACCOUNT";
			}

			// check balance of sender
			float balance = dao.findBalance(transferBean.getFromAccountNumber());
			if (balance < transferBean.getAmount()) {
				throw new InsufficientFundsException();
			}

			// process transfer
			transferBean.setTransactionID(dao.generateSequenceNumber());
			if (!dao.updateBalance(transferBean.getFromAccountNumber(), balance - transferBean.getAmount())) {
				return "FAILURE";
			}

			float toAccountBalance = dao.findBalance(transferBean.getToAccountNumber());
			if (!dao.updateBalance(transferBean.getToAccountNumber(), toAccountBalance + transferBean.getAmount())) {
				return "FAILURE";
			}

			if (dao.transferMoney(transferBean)) {
				return "SUCCESS";
			} else {
				return "FAILURE";
			}
		} catch (SQLException e) {
			System.out.println(e);
			return "FAILURE";
		} catch (InsufficientFundsException e) {
			return e.toString();
		}
	}
}
