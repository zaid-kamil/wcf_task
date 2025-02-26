package com.wipro.talentnext;

public class BankDemo {
	public static void main(String[] args) {
		RBI sbi = new SBI();
		System.out.println("SBI interest amount =>"+sbi.interesetAmount());
		RBI icici = new ICICI();
		System.out.println("SBI interest amount =>"+icici.interesetAmount());
	}
}
