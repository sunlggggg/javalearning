package xyz.neolith.javalearning.concurrent.thread.callback.asynchronous;

/**
 * 耗时操作
 *
 * @author sunlggggg
 */
public class FileReader {
    String read() throws InterruptedException {
        System.out.println("reading ...");
        Thread.sleep(3000L);
        System.out.println("finish ...");
        return "I am sunlggggg.";
    }
}
