package xyz.neolith.javalearning.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author sunligang
 * @date 2018/09/25
 */
public class ReadWriteLockTest {
    // 创建一个读写锁
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static void read(Thread thread) {
        readWriteLock.readLock().tryLock();
        while (true) {
            System.out.println(thread.getName());
        }
    }
    public static void main(String[] args) {
        new Thread(() -> read(Thread.currentThread())).start();
        new Thread(() -> read(Thread.currentThread())).start();
    }
}
