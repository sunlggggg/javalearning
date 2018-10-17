package com.github.sunlggggg.javalearning.basicknowledge;

/**
 * @author sunlggggg
 * @date 2018/4/10
 */

public class ErrorTest {
    private static void testError(){
        throw new StackOverflowError();
    }
    public static void main(String[] args) {
        try {
            ErrorTest.testError();
        }catch (Throwable throwable ) {
            //catch error
            throwable.printStackTrace();
        }
    }
}
