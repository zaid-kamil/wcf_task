package com.wipro.thread_creation;

import java.util.Random;

public class ColorDisplay implements Runnable {
	private String[] colors = {"white", "blue", "black", "green", "red", "yellow"};
    private Random random = new Random();
	
    @Override
	public void run() {
    	while (true) {
    		int index = random.nextInt(colors.length);
    		System.out.println(colors[index]);
    		if(colors[index].equalsIgnoreCase("red")) {
    			break;
    		}
    		try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Thread was interrupted!");
			}
    	}
	}
    
    public static void main(String[] args) {
    	ColorDisplay colourDisplay = new ColorDisplay();
        Thread thread = new Thread(colourDisplay);
        thread.start();
	}

}
