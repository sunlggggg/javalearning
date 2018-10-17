package com.github.sunlggggg.javalearning.concurrent.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptTest {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockInterruptTest test = new LockInterruptTest();
        new Thread(() -> {
            try {
                test.insert(Thread.currentThread());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            }
        }).start();

        Thread thread2 = new Thread(() -> {
            try {
                test.insert(Thread.currentThread());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            }
        });
        thread2.start();
        thread2.interrupt();
    }

    private void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println(thread.getName() + "得到了锁");
            while (true) ;
        } finally {
            lock.unlock();
        }
    }
}
