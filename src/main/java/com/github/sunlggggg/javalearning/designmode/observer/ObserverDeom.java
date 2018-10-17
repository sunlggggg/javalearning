package com.github.sunlggggg.javalearning.designmode.observer;

public class ObserverDeom {
    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.setNum(12);//no observer

        new BinaryObserver(subject);
        subject.setNum(1000);//only one observer

        new HexObserver(subject);
        subject.setNum(23);//two observers
    }
}
