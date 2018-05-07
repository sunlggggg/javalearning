package xyz.neolith.javalearning.designmode.observer;

/**
 * 观察者抽象类
 * @author sunlggggg
 */
public abstract class Observer {
    protected Subject subject ; //被观察对象
    public abstract void update();
}
