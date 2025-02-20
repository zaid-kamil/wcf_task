package com.wipro.employee.beans;

public class EmployeeBean {
	private int id;
	private String name;
	private String email;
	private String dept;

	public EmployeeBean(String name, String email, String dept) {
		this.name = name;
		this.email = email;
		this.dept = dept;
	}

	public EmployeeBean(int id, String name, String email, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dept = dept;
	}

	public EmployeeBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void show() {
		System.err.println("----🧑----");
		System.out.println("🔑Eid: " + id);
		System.out.println("🤵Name: " + name);
		System.out.println("📧Email: " + email);
		System.out.println("🏢Dept: " + dept);
		System.out.println();
	}
}
