package xyz.neolith.javalearning.concurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sunligang
 * @date 2018/09/26
 */
public class ConditionTest {
    final static Lock lock = new ReentrantLock();
    final static Condition notFull = lock.newCondition();
    final static Condition notEmpty = lock.newCondition();

    final static Object[] buffer = new Object[100];

    static int putPtr = 0, takePtr = 0, count = 0;

    static void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            // 缓冲满，线程阻塞
            while (count == buffer.length) {
                notFull.await();
            }
            buffer[putPtr] = x;
            if (++putPtr == buffer.length) {
                putPtr = 0;
            }
            ++count;
            // 唤醒读线程
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    static Object take() throws InterruptedException {
        Object x;
        lock.lock();
        try {
            while (count == 0) {


                notEmpty.await();
            }
            x = buffer[takePtr];
            if (++takePtr == buffer.length) {
                takePtr = 0;
            }
            --count;
            notFull.signal();
        } finally {
            lock.unlock();
        }
        return x;
    }

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println(take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
