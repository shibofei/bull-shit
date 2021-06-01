package com.example.demo;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSwitch {
    static Thread t1 = null;
    static Thread t2 = null;
    static char[] chars1 = "A B C D E F".toCharArray();
    static char[] chars2 = "1 2 3 4 5 6".toCharArray();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("reentrant lock: ");
        switchLock();
        TimeUnit.MILLISECONDS.sleep(100); //等待switchLock();执行完成

        System.out.println("\nthread park: ");
        switchPark();
        TimeUnit.MILLISECONDS.sleep(100);  //等待switchPark();执行完成


        System.out.println("\ntransfer queue: ");
        switchTransferQueue();
        TimeUnit.MILLISECONDS.sleep(100); //等待switchLock();执行完成
    }

    public static void switchLock() {
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        t1 = new Thread(() -> {
            lock.lock();
            try {
                for (char c : chars1) {
                    System.out.print(c);
                    c2.signal();
                    c1.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1");
        t2 = new Thread(() -> {
            lock.lock();
            try {
                for (char c : chars2) {
                    c2.await();
                    System.out.print(c);
                    c1.signal();
                }
                c1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    public static void switchPark() {
        t1 = new Thread(() -> {
            for (char c : chars1) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : chars2) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
            LockSupport.unpark(t1);
        }, "t2");

        t1.start();
        t2.start();
    }

    public static void switchTransferQueue() {
        LinkedTransferQueue<Character> tq = new LinkedTransferQueue<>();
        t1 = new Thread(() -> {
            try {
                for (char c : chars1) {
                    tq.transfer(c);
                    System.out.print(tq.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2 = new Thread(() -> {
            try {
                for (char c : chars2) {
                    System.out.print(tq.take());
                    tq.transfer(c);
                }
                tq.transfer(null);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }
}
