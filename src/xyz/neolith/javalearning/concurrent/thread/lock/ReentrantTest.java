package xyz.neolith.javalearning.concurrent.thread.lock;


/**
 * @author sunligang
 * @date 2018/09/25
 */
public class ReentrantTest {
    public synchronized void method1() {
        System.out.println("method 1 " + Thread.currentThread().getName());
        method2();
        while (true);
    }

    public synchronized void method2() {
        System.out.println("method 2 " + Thread.currentThread().getName());
        while (true);
    }

    public synchronized void method3() {
        System.out.println("method 2 " + Thread.currentThread().getName());
        while (true);
    }
    public static void main(String[] args) {
        ReentrantTest testReentrant = new ReentrantTest();
        ReentrantTest testReentrant2 = new ReentrantTest();
        new Thread(()-> testReentrant.method2()).start();
        new Thread(()-> testReentrant2.method1()).start();
        new Thread(()-> testReentrant.method3()).start();
    }
}
