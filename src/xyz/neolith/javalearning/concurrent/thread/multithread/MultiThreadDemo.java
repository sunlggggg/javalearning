package xyz.neolith.javalearning.concurrent.thread.multithread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sunlggggg
 * @date 2018-05-10 14:41.
 */

public class MultiThreadDemo {
    static class Task implements Runnable {
        private String threadName;

        Task(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(threadName);
                if ("0".equals(threadName)) {
                    System.out.println(1/0);
                }
            }
        }
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingDeque(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.MILLISECONDS, blockingQueue);
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Task(String.valueOf(i)));
        }
    }
}
