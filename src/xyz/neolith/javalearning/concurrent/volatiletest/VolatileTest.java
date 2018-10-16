package xyz.neolith.javalearning.concurrent.volatiletest;

/**
 * @author sunligang
 * @date 2018/09/26
 */
public class VolatileTest {
    volatile int i;

    public void addI(){
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        final  VolatileTest test01 = new VolatileTest();
        for (int n = 0; n < 1000; n++) {
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test01.addI();
            }).start();
        }

        //等待10秒，保证上面程序执行完成
        Thread.sleep(10000);

        System.out.println(test01.i);
    }
}
