package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;


public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            String s = "";
            while (true) {
                s = (String) queue.poll();
                System.out.println(s);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
