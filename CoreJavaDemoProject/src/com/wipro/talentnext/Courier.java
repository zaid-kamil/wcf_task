package com.wipro.talentnext;

public interface Courier {
	float minTransactionRate = 100.10f;
	String parcelService();
	default void display() {
		System.out.println("Default Method");
	}
	
	static void displayStatic() {
		System.out.println("Static Method");
	}
}
