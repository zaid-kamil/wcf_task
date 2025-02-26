package com.wipro;

public class RaceApp {
	public static void main(String[] args) {
		Animal animal = new Animal();
		Thread hareThread = new Thread(animal, "Hare");
		Thread tortoiseThread = new Thread(animal, "Tortoise");
		
		hareThread.setPriority(Thread.MAX_PRIORITY);
		
		hareThread.start();
		tortoiseThread.start();
	}
}
