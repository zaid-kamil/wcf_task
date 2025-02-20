package com.wipro.talentnext;

public class BlueDart implements Courier {
	@Override
	public String parcelService() {
		return "BlueDart: Successfully delivered";
	}
	@Override
	public void display() {
		System.out.println("Updated Default Method");
	}
}
