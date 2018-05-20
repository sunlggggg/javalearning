package xyz.neolith.javalearning.concurrent.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sunlggggg
 * @date 2018/3/29
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(10);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1000L, TimeUnit.MILLISECONDS, workQueue);
        for(int i = 1; i < 20 ; i++){
            threadPoolExecutor.execute(()->{
                System.out.println();
            });
        }
    }
}
