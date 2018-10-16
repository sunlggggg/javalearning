package xyz.neolith.javalearning.concurrent;

import java.util.concurrent.TimeUnit;

class SleepUtils {
    static final void second (long seconds ){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class ThreadState {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        // 使用两个Blocked线程，一个获取锁成功，一个获取锁失败
        new Thread(new Blocked(), "BlockedThread").start();
        new Thread(new Blocked(), "BlockedThread").start();
    }

    // 该线程不断进行线程睡眠
    static class TimeWaiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100); 
            }
        }
    }

    // 该线程在Waiting.class 实例上等待
    static class Waiting implements Runnable {
        @Override 
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    // 该线程在 Blocked.class 实例上加锁后，不会释放锁
    static class Blocked implements Runnable {
        public void run (){
            synchronized (Blocked.class){
                while (true) {
                    SleepUtils.second(100); 
                }
            }
        }
    }
}
