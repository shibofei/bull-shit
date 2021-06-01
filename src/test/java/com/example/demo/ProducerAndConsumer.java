package com.example.demo;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        BlockingDeque<Integer> queue = new LinkedBlockingDeque<>(10);
        for (int i = 0; i < 10; i++) {
            int element = i;
            new Thread(() -> {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        queue.put(element);
                        System.out.println(Thread.currentThread().getName() + " put element " + element);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "Producer" + i).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        int element = queue.take();
                        System.out.println(Thread.currentThread().getName() + " take element " + element);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "Consumer" + i).start();
        }
    }
}