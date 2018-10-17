package com.github.sunlggggg.javalearning.designmode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察对象
 *
 * @author sunlggggg
 */
public class Subject {
    List<Observer> observers = new ArrayList<>();//添加的观察者

    private int num; // value is observed

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
        notifyAllObservers();//notify all the observers
    }

    void attach(Observer observer){
        observers.add(observer);
    }
    void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
