package com.wipro.thread_control_n_priorties;

public class EvenOddThreads {

    public static void main(String[] args) {
        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 2; i <= 20; i += 2) {
                    System.out.println("Even: " + i);
                }
            }
        });

        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 19; i += 2) {
                    System.out.println("Odd: " + i);
                }
            }
        });

        evenThread.start();
        try {
            evenThread.join(); // Wait for evenThread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        oddThread.start();
        try {
            oddThread.join(); // Wait for oddThread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}