package xyz.neolith.javalearning.innerclass.commoninner;

/**
 * Author :sunlggggg
 * Date   :2018-05-09 11:08.
 */
public class OuterTest {
    public static void main(String[] args) {
//        new Outer.Inner(); 无法直接创建普通内部类
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();//通过外部类创建普通内部类

        inner.nonStaticInnerFun();
    }

}
