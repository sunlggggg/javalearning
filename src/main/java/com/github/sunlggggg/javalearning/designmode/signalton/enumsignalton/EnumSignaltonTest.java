package com.github.sunlggggg.javalearning.designmode.signalton.enumsignalton;

public class EnumSignaltonTest {
    public static void main(String[] args) {
        Master master01 = Master.instance;
        Master master02 = Master.instance;
        System.out.println(master01.getVal());
        System.out.println(master01 == master02);
    }
}
