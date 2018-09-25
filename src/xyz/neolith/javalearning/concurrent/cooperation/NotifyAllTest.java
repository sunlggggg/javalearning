package xyz.neolith.javalearning.concurrent.cooperation;

/**
 * @author sunligang
 * @date 2018/09/25
 */
public class NotifyTest {
    // synchronized 提供了 monitor
    public synchronized void testWait() {
        System.out.println(1);
        try {
            wait(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }

    public static void main(String[] args) {
        NotifyTest notifyTest = new NotifyTest();
        new Thread(()-> notifyTest.testWait()).start();
        synchronized (notifyTest) {
            notifyTest.notifyAll();
        }
    }
}
