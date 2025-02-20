package com.wipro.six.beans;

public class Car {
	private String color;
	private String model;
	private Driver driver;

	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	public Car(String color) {
		super();
		this.color = color;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public Driver getDriver() {
		return driver;
	}


	public void setDriver(Driver driver) {
		this.driver = driver;
	}


	@Override
	public String toString() {
		return "Car";
	}
}
