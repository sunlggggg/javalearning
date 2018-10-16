package xyz.neolith.javalearning.concurrent.cooperation;

/**
 * @author sunligang
 * @date 2018/09/25
 */
public class YieldTest implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        YieldTest run  = new YieldTest();
        Thread t1 = new Thread(run,"FirstThread");
        Thread t2 = new Thread(run,"SecondThread");

        t1.start();
        t2.start();

    }
}
