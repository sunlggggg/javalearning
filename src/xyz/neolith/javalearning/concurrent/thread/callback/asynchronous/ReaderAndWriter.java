package xyz.neolith.javalearning.concurrent.thread.callback.asynchronous;

import xyz.neolith.javalearning.concurrent.thread.callback.synchronous.DBWriter;
import xyz.neolith.javalearning.concurrent.thread.callback.synchronous.FileReader;

public class ReaderAndWriter {
    private ASynOperation aSynOperation;

    ReaderAndWriter(ASynOperation aSynOperation) {
        this.aSynOperation = aSynOperation; //设置回调
    }
    void readAndWrite() {
        new Thread(() -> {
            try {
                new DBWriter().writer(new FileReader().read());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            aSynOperation.info();
        }).start();
    }
}
