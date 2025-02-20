package com.wipro.trainee.model;

public class Trainee {
	private int tid;
	private String traineeName;
	private String courseName;
	private String mobileNumber;
	private String email;
	static String companyName;

	public Trainee() {
		super();
	}

	public Trainee(int tid, String traineeName, String courseName, String mobileNumber, String email) {
		this.tid = tid;
		this.traineeName = traineeName;
		this.courseName = courseName;
		this.mobileNumber = mobileNumber;
		this.email = email;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Trainee [tid=" + tid + ", traineeName=" + traineeName + ", courseName=" + courseName + "]";
	}
	
	

}
