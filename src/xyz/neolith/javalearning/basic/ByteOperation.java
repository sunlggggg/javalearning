package xyz.neolith.javalearning.basic;

import org.junit.Test;

public class ByteOperation {
    @Test
    public void testBitOr(){
        int a = 0b1011;
        int b = 0b0011;
        System.out.println(Integer.toBinaryString(a|b));
    }
}
