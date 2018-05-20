package xyz.neolith.javalearning.concurrent.thread.callback.asynchronous;

/**
 * 异步回调的方式完成将文件中的数据读取并写入到数据库
 *
 * @author sunlggggg
 */
public class AsynOperation {
    void info() {
        System.out.println("confirmation message: we finish this task");
    }

    /**
     * 读取文件并在读完后告知调用DB
     *
     * @param args jvm 参数
     */
    public static void main(String[] args) {
        new ReaderAndWriter(new AsynOperation()).readAndWrite();
        System.out.println("this is asynchronous ...");
    }
}
