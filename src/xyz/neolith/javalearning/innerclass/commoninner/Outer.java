package xyz.neolith.javalearning.innerclass.commoninner;

/**
 * Author :sunlggggg
 * Date   :2018-05-09 11:02.
 */
public class Outer {
    static String staticOuterField = "staticOuterField";
    String nonStaticOuterField = "nonStaticOuterField";
    class Inner {
//        static String staticInnerField; 无法在普通内部类中定义静态变量
//        static void staticInnerFun(){} 无法在普通内部类中定义静态方法

        String nonStaticInnerField;

        void nonStaticInnerFun(){
            System.out.println(Outer.staticOuterField);//可以访问外部静态变量
            System.out.println(nonStaticOuterField);  //可以访问外部非静态变量
        }
    }

}
