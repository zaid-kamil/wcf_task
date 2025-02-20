package com.wipro.talentnext;

public class ExceptionDemo {
	public static void main(String[] args) {
		try {
			int a = 10/0;
			System.out.println(args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("⚠️ " + e.getMessage());
		} catch (Exception e) {
			System.out.println("⚠️ "+e.getMessage());
		}
		System.out.println("Completed");
	}
}
