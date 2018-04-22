package xyz.neolith.javalearning.concurrent.thread.callback.asynchronous;

/**
 * 耗时操作
 */
public class DBWriter {
    void writer(String res ) throws InterruptedException {
        System.out.println("write into db ...");
        Thread.sleep(3000L);
        System.out.println("the info is " + res);
        System.out.println("write finish");
    }
}
