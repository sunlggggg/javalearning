package com.github.sunlggggg.javalearning.collection.unmodify;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author sunligang
 * @date 2019/07/08
 */
public class UnmodifiableListTest {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>(3);

        for (int i = 0; i < 100; i++) {
            l.add("d");
        }

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), r -> {
            Thread thread = new Thread(r);
            thread.setName("test" + UUID.randomUUID().toString());
            return thread;
        });

        threadPoolExecutor.execute(() -> {
            for (Object aL : l) {
                System.out.println(aL);
            }
        });

        l.add("d");
    }
}
