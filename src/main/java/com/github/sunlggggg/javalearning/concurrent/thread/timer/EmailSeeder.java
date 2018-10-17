package com.github.sunlggggg.javalearning.concurrent.thread.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author sunlggggg
 * @date 2018/4/4
 */
public class EmailSeeder {

    public static void seed( String emailInfo,Long delayTime ){
        Timer timer = new Timer();
        timer.schedule(new SeedEmailTask(emailInfo,timer ), delayTime );//第二个参数是延迟时间
    }

    public static void main(String[] args) {
        EmailSeeder.seed("一封来自陌生人的来信1...",3000L);
        EmailSeeder.seed("一封来自陌生人的来信2...",3000L);
        EmailSeeder.seed("一封来自陌生人的来信3...",3000L);
        EmailSeeder.seed("一封来自陌生人的来信4...",3000L);
        EmailSeeder.seed("一封来自陌生人的来信5...",3000L);
        EmailSeeder.seed("一封来自陌生人的来信6...",3000L);
        EmailSeeder.seed("一封来自陌生人的来信7...",3000L);
        EmailSeeder.seed("一封来自陌生人的来信8...",3000L);
        EmailSeeder.seed("一封来自陌生人的来信9...",3000L);
        EmailSeeder.seed("一封来自陌生人的来信10...",3000L);
    }

    private static class SeedEmailTask extends TimerTask {
        private Timer timer;
        private final String emailInfo;
        SeedEmailTask(String emailInfo, Timer timer ){
            this.emailInfo = emailInfo;
            this.timer = timer;
        }
        @Override
        public void run() {
            //待修改。。。
            System.out.println("seed: " + emailInfo);
            timer.cancel();
        }
    }
}
