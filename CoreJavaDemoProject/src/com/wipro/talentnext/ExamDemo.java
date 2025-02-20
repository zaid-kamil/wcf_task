package com.wipro.talentnext;

public class ExamDemo {
	public static void main(String[] args) {
		Exam e1 = new Exam();
		try {
			System.out.println(e1.validateAge(55));
		} catch (AgeValidationException e) {
			System.err.println(e.getMessage());
		}
		try {
			System.out.println(e1.validateAge(5));
		} catch (AgeValidationException e) {
			System.err.println(e.getMessage());
		}
	}
}
