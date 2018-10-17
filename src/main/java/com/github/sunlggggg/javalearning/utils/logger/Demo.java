package com.github.sunlggggg.javalearning.utils.logger;

/**
 * @author sunlggggg
 * @date 2018-05-11 21:22.
 */
public class Demo {
    private static Logger logger = Logger.Builder.getLogger(Demo.class);

    public static void main(String[] args) {
        logger.info("hello world");

        logger.err("hello world");

        logger.warn("hello world");
    }
}
