package com.github.sunlggggg.javalearning.concurrent.thread.lock;

/**
 * @author sunligang
 * @date 2018/09/25
 */
public class TestSyncBlock {
    void read() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            while (true) ;
        }
    }

    public static void main(String[] args) {
        TestSyncBlock testSyncBlock = new TestSyncBlock();
        new Thread(() -> testSyncBlock.read()).start();
        new Thread(() -> testSyncBlock.read()).start();
        new Thread(() -> testSyncBlock.read()).start();
        new Thread(() -> testSyncBlock.read()).start();
    }
}
