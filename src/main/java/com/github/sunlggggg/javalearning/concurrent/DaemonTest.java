package com.github.sunlggggg.javalearning.concurrent;

import java.util.concurrent.TimeUnit;


public class DaemonTest {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            try{
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                System.out.println("DaemonThread finally run. ");
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
