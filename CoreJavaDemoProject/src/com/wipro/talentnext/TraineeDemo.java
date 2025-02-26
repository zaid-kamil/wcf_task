package com.wipro.talentnext;

public class TraineeDemo {
	public static void main(String[] args) {
		Trainee trainee1 = new Trainee();
		trainee1.setTid(2390);
		trainee1.setTraineeName("Ravi Kumar");
		trainee1.setCourseName("Wipro Certified Faculty");
		trainee1.setMobileNumber("2139812922");
		trainee1.setEmail("ravikumar@gmail.com");
		Trainee.companyName = "Mohan Babu University";
		System.out.println(trainee1.getTraineeName());
		System.out.println(trainee1.getCourseName()); 
	}
}
