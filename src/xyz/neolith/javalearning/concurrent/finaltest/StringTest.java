package xyz.neolith.javalearning.concurrent.finaltest;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author sunligang
 * @date 2018/09/27
 */
public class StringTest {
    static String s = "";

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            new Thread(() -> s = "/tmp/usr".substring(4)).start();
            new Thread(() -> {
                String myS = s;
                if (myS.equals("/tmp"))
                    System.out.println(myS);
            }).start();
            Thread.sleep(3);
        }
    }
}
