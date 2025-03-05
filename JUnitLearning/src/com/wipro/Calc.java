package com.wipro;

public class Calc {
	public int add(int a, int b) {
		return a + b;
	}
	
	public static void main(String[] args) {
		Calc c= new Calc();
		System.out.println(c.add(213, 233));
		
	}
}
