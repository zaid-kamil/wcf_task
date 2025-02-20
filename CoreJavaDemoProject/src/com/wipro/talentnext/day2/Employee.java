package com.wipro.talentnext.day2;

public class Employee implements Comparable<Employee> {

	private int empId;
	private String name;
	private String email;
	
	public Employee(int empId, String name, String email) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
	}

	// sorting
	@Override
	public int compareTo(Employee e) {
		return this.name.compareTo(e.name);
	}

	@Override
	public String toString() {
		return  name;
	}
	

}
