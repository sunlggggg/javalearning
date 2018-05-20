package xyz.neolith.javalearning.stream;

import xyz.neolith.javalearning.utils.logger.Logger;
import xyz.neolith.javalearning.utils.logger.LoggerUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/05/14
 */
public class SumDemo {
    private static final int repeated_times = 10;
    private static Logger logger = LoggerUtil.getLogger(SumDemo.class);

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < repeated_times; i++) {
            list.add(i);
        }
        list.parallelStream().filter((v) -> v % 2 == 0).reduce((a, b) -> a + b).ifPresent(integer -> logger.info(String.valueOf(integer)));
    }
}

