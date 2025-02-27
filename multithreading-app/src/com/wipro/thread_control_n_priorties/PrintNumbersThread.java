package com.wipro.thread_control_n_priorties;

public class PrintNumbersThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            if (i == 5) {
                try {
                    Thread.sleep(5000); // Delay for 5000 milliseconds (5 seconds)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintNumbersThread thread = new PrintNumbersThread();
        thread.start();
    }
} 