package xyz.neolith.javalearning.concurrent;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class InterruptedTest {
    public static void main(String[] args) {
        Thread sleepThread = new Thread(()->{
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"SleepThread");


        Thread busyThread = new Thread(()->{
            while (true) {

            }
        },"BusyThread");

        sleepThread.setDaemon(true);
        busyThread.setDaemon(true); 

        sleepThread.start();
        busyThread.start(); 

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e ){
            e.printStackTrace();
        }

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
        
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e ){
            e.printStackTrace();
        }
    }
}