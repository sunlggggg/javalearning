package xyz.neolith.javalearning.threadlocal;

import com.sun.istack.internal.NotNull;
import xyz.neolith.javalearning.utils.logger.Logger;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sunligang
 * @date 2018/07/04
 */
public class ThreadLocalDemo {
    private static Logger logger = Logger.Builder.getLogger(ThreadLocalDemo.class);

    static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> Thread.currentThread().getName());


    public static void main(String[] args) {
        logger.info("thread name: " + threadLocal.get());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                2,
                2,
                TimeUnit.HOURS,
                new LinkedBlockingDeque<>(),
                new ThreadFactory() {
                    int counter;

                    @Override
                    public Thread newThread(@NotNull Runnable r) {
                        return new Thread(r, "thread-" + counter++);
                    }
                }
        );
        run(threadPoolExecutor, 1);
        run(threadPoolExecutor, 2);
        run(threadPoolExecutor, 3);
        run(threadPoolExecutor, 4);
    }

    private static void run(ThreadPoolExecutor threadPoolExecutor, int id) {
        int repeatCount = 10;
        threadPoolExecutor.execute(() -> {
            for (int i = 0; i < repeatCount; i++) {
                logger.info("thread name: " + threadLocal.get() + "\t id:" + id);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
