package com.github.sunlggggg.javalearning.stream;

import com.github.sunlggggg.javalearning.utils.logger.Run;

import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * @author sunligang
 * @date 2019/07/08
 */
public class ParalleDemo {
    class RaralleDemo implements Run<Long> {
        @Override
        public Long run() {
            return LongStream.rangeClosed(2, 10000000)
                    .mapToObj(BigInteger::valueOf)
                    .filter(i -> i.isProbablePrime(50))
                    .count();
        }
    }

    public static void main(String[] args) {

    }
}
