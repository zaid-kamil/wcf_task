package com.wipro.hibernateapp.entity;

public class Employee {
	private int id;
	private String empName;
	private String email;
	private String department;

	public Employee() {
		// hibernate reqiures empty constructor
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + "]";
	}
	
	public void show() {
		System.err.println("----🧑----");
		System.out.println("🔑Eid: " + id);
		System.out.println("🤵Name: " + empName);
		System.out.println("📧Email: " + email);
		System.out.println("🏢Dept: " + department);
		System.out.println();
	}
}
