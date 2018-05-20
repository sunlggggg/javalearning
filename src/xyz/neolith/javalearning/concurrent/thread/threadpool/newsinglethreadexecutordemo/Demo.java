package xyz.neolith.javalearning.concurrent.thread.threadpool.newsinglethreadexecutordemo;


import xyz.neolith.javalearning.utils.logger.Logger;
import xyz.neolith.javalearning.utils.logger.LoggerUtil;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author sunlggggg
 * @date 2018-05-10 13:57.
 */
public class Demo {

    private static Logger logger = LoggerUtil.getLogger(Demo.class);
    private static final int REPEAT_COUNT = 10;
    private static final String THREAD_NAME = "Demo";
    private static int counter = 0;

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), r -> {
            Thread t = new Thread(r, THREAD_NAME + counter);
            counter++;
            logger.info(t.getName());
            return t;
        });
        threadPoolExecutor.execute(() -> {
            Random random = new Random();
            for (int i = 0; i < REPEAT_COUNT; i++) {
                logger.info("one" + random.nextInt());
            }
        });

        threadPoolExecutor.execute(() -> {
            Random random = new Random();
            for (int i = 0; i < REPEAT_COUNT; i++) {
                logger.info("two:" + random.nextInt());
            }
        });
    }
}


