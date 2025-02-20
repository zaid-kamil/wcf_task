package com.wipro.talentnext;

public class AgeValidationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int age;

	public AgeValidationException(int age) {
		super();
		this.age = age;
	}

	@Override
	public String getMessage() {
		return "Age : " + age + " is not valid";
	}

}
