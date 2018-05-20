package xyz.neolith.javalearning.innerclass.staticinner;

/**
 * @author sunlggggg
 * @date 2018/5/9
 */
public class OuterTest {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();
        inner.nonStaticInnerFun();
        inner.staticInnerFun();
        Outer.Inner.staticInnerFun();
    }
}
