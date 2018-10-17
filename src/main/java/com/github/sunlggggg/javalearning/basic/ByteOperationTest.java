package com.github.sunlggggg.javalearning.basic;

import org.junit.Test;
/**
 * 字节操作
 *
 * @author sunlggggg
 */
public class ByteOperationTest {
    @Test
    public void testBitOr() {
        int a = 0b1011;
        int b = 0b0011;
        System.out.println(Integer.toBinaryString(a | b));
    }
}
