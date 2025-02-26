package com.wipro.tm14_proj1;

class Employee {
	String firstName;
	String lastName;
	String mobile;
	String email;
	String address;

	public Employee(String firstName, String lastName, String mobile, String email, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}

	@Override
	public String toString() {
		return String.format("%-15s %-15s %-15s %-30s %-15s", firstName, lastName, mobile, email, address);
	}
}