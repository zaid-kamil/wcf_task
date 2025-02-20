package com.wipro.talentnext;

public class Parent {
	// always first
	static {
		System.out.println("Static block");
	}
	// second
	{
		System.out.println("Non Static block");
	}
	// third
	public Parent() {
		super();
		System.out.println("Default constructor");
	}
	
}
