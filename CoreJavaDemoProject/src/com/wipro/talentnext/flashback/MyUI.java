package com.wipro.talentnext.flashback;

public class MyUI {
	public static void main(String[] args) {
		Button b = new  Button(2);
		b.addEventListener(() -> System.out.println("ON CLICK EVENT"));
	}
}
