package com.wipro.thread_control_n_priorties;

public class ThreadPriorityExample {

    public static void main(String[] args) {
        Thread maxPriorityThread = new Thread(new Task(), "Max Priority Thread");
        Thread minPriorityThread = new Thread(new Task(), "Min Priority Thread");
        Thread normPriorityThread = new Thread(new Task(), "Norm Priority Thread");

        maxPriorityThread.setPriority(Thread.MAX_PRIORITY); // Set to maximum priority
        minPriorityThread.setPriority(Thread.MIN_PRIORITY); // Set to minimum priority
        normPriorityThread.setPriority(Thread.NORM_PRIORITY); // Set to normal priority

        maxPriorityThread.start();
        minPriorityThread.start();
        normPriorityThread.start();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " started.");
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " is running.");
            }
            System.out.println(Thread.currentThread().getName() + " finished.");
        }
    }
}

