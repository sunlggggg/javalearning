package xyz.neolith.javalearning.concurrent.thread.callback.asynchronous;

import xyz.neolith.javalearning.concurrent.thread.callback.synchronous.DBWriter;
import xyz.neolith.javalearning.concurrent.thread.callback.synchronous.FileReader;

/**
 * @author sunlggggg
 */
public class ReaderAndWriter {
    private AsynOperation asynOperation;

    ReaderAndWriter(AsynOperation asynOperation) {
        this.asynOperation = asynOperation; //设置回调
    }

    void readAndWrite() {
        new Thread(() -> {
            try {
                new DBWriter().writer(new FileReader().read());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            asynOperation.info();
        }).start();
    }
}
