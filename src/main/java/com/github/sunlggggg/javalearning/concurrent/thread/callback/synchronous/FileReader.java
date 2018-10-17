package com.github.sunlggggg.javalearning.concurrent.thread.callback.synchronous;

/**
 * 耗时操作
 */
public class FileReader {
    public String read() throws InterruptedException {
        System.out.println("reading ...");
        Thread.sleep(3000L);
        System.out.println("finish ...");
        return "I am sunlggggg.";
    }
}
