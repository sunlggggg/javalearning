package xyz.neolith.javalearning.fp;

import org.junit.Test;
import xyz.neolith.javalearning.utils.logger.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author sunligang
 * @date 2018/06/28
 */
public class LambdaTest {
    private static Logger logger = Logger.Builder.getLogger(LambdaTest.class);
    @Test
    public void test1() {
        class Int {
            public Int(int val) {
                this.val = val;
            }

            @Override
            public String toString() {
                return "Int{" +
                        "val=" + val +
                        '}';
            }

            public int val;
        }
        List<Integer> lObjects = new ArrayList<>();
        lObjects.add(1);
        lObjects.add(2);
        lObjects.add(3);
        List<Int> lInts = lObjects.stream().parallel().map(e-> new Int(e)).collect(Collectors.toList());

        lInts.forEach((e)-> logger.info(e));
    }
}
