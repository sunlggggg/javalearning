package xyz.neolith.javalearning.innerclass.staticinner;

/**
 * Author :sunlggggg
 * Date   :2018-05-09 11:02.
 */
public class Outer {
    static String staticOuterField = "staticOuterField";
    String nonStaticOuterField = "nonStaticOuterField";

    static class Inner {
        static String staticInnerField; //可以在静态内部类中定义静态变量

        //可以在静态内部类中定义静态方法
        static void staticInnerFun() {
//            System.out.println(nonStaticOuterField); 静态方法内无法访问外部的非静态变量
            System.out.println("staticInnerFun");
        }

        String nonStaticInnerField;

        void nonStaticInnerFun() {
            System.out.println(Outer.staticOuterField);//可以访问外部静态变量
//            System.out.println(nonStaticOuterField);  //无法访问外部非静态变量
        }
    }

}
