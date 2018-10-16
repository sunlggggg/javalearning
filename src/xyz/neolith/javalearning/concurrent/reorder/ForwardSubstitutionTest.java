package xyz.neolith.javalearning.concurrent.reorder;

import java.util.Date;

/**
 * @author sunligang
 * @date 2018/09/27
 */
public class ForwardSubstitutionTest {
    static class D {
        public int x;
    }

    public static void main(String[] args) {
        // 目前已经无法复现 前置替换的引发的问题
        while (true) {
            D p = new D();
            p.x = 0;
            D q = p;
            new Thread(() -> {
                D r6 = p;
                r6.x = 3;
            }).start();
            new Thread(() -> {
                D r1, r3;
                r1 = p;
                int r2 = r1.x;
                r3 = q;
                int r4 = r3.x;
                // 重用了r2
                int r5 = r1.x;
                System.out.println("r2:" + r2);
                System.out.println("r5:" + r5);
                System.out.println("r4:" + r4);
                System.out.println("-----");
            }).start();


        }

    }
}
