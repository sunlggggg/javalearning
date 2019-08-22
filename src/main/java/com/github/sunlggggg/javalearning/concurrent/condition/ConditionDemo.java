package com.github.sunlggggg.javalearning.concurrent.condition;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunligang
 * @date 2019/08/18
 */
public class ConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3, r -> {
            Thread t = new Thread(r);
            t.setName("demo" + atomicInteger.getAndIncrement());
            return t;
        });

        executor.schedule(() -> {
            try {
                lock.lock();
                System.out.println(1);
                condition1.await();
                System.out.println(Thread.currentThread().getName());
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, 1, TimeUnit.SECONDS);

        executor.schedule(() -> {
            lock.lock();
            System.out.println(2);
            try {
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            lock.unlock();
        }, 2, TimeUnit.SECONDS);

        executor.schedule(() -> {
            lock.lock();
            System.out.println(2);
            try {
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            lock.unlock();
        }, 3, TimeUnit.SECONDS);

        Thread.sleep(10000L);

        System.out.println(1);
    }
}
