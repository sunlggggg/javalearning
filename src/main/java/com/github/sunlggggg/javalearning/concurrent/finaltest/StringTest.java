package com.github.sunlggggg.javalearning.concurrent.finaltest;


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
