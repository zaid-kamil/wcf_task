package com.wipro.talentnext;

public class CourierDemo {

	public static void main(String[] args) {
		Courier courier1 = new BlueDart();
		String status = courier1.parcelService();
		System.out.println(status);
		courier1.display();
		Courier.displayStatic();
	}

}
