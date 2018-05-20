package xyz.neolith.javalearning.designmode.signalton.enumsignalton;

/**
 * enum 实现的单例， 普通单例可以通过反射创建多个实例
 * JVM会保证enum不能被反射并且构造器方法只执行一次
 * @author sunlggggg
 * @date 2018/5/9
 */
public enum Master {
    instance("商吉琪");

    private final String name;

    Master(String name) {

        this.name = name;
    }

    public String getVal() {

        return this.name;
    }

}
