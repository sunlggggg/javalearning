package xyz.neolith.javalearning.concurrent.reorder;

import sun.jvm.hotspot.c1.Runtime1;

/**
 * @author sunligang
 * @date 2018/09/27
 */
public class ReOrderTest {
    static int A , B;

    public static void main(String[] args) {
        // 尝试观察 r1 == 1 ; r2 == 2
        while (true) {
            A = B = 0 ;
            new Thread(() -> {
                int r2 = A;
                B = 1;
                System.out.println("r2:" + r2);
            }).start();

            new Thread(() -> {
                int r1 = B;
                A = 2;
                System.out.println("r1:" + r1);
            }).start();
        }
    }
}
