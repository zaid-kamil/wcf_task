package com.wipro.six.beans;

public class Driver {
	private String name;

	public Driver() {
		System.out.println("Driver ready");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
