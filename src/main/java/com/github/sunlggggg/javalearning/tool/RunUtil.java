package com.github.sunlggggg.javalearning.tool;

import com.github.sunlggggg.javalearning.utils.logger.Logger;
import com.github.sunlggggg.javalearning.utils.logger.Run;

/**
 * @author sunligang
 * @date 2019/07/08
 */
public class RunUtil {
    private static Logger logger = Logger.Builder.getLogger(RunUtil.class);

    public static <T> T run(Run<T> run) {
        long cur = System.currentTimeMillis();
        T ret = run.run();
        logger.info(System.currentTimeMillis() - cur);
        return ret;
    }
}
