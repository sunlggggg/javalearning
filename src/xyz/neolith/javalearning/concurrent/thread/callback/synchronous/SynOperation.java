package xyz.neolith.javalearning.concurrent.thread.callback.synchronous;

/**
 * 同步的方式完成将文件中的数据读取并写入到数据库
 */
public class SynOperation {

    //读取文件并在读完后告知调用DB
    public static void main(String[] args) throws InterruptedException {
        new DBWriter().writer(new FileReader().read());
        System.out.println("the synchronous operation");
    }
}
