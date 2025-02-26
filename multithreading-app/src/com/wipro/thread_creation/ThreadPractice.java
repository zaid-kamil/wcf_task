package com.wipro.thread_creation;

public class ThreadPractice {
	public static void main(String[] args) {
		Character character = new Character();
		Thread t1 = new Thread(character, "Scooby");
		Thread t2= new Thread(character, "Shaggy");
		
		System.out.println(t1.getName());
		System.out.println(t2.getName());
	}
}

class Character implements Runnable {

	@Override
	public void run() {
		System.out.println("Threads");
	}

}
