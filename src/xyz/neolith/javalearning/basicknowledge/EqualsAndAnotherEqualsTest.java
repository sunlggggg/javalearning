package xyz.neolith.javalearning.basicknowledge;

/**
 * 比较 == 和 equals
 * /*
 *Object类 == 和 equals相同
 *public boolean equals(Object obj) {
 *  return (this == obj);
 *}
 * @author sunlggggg
 * @date 2018/4/10
 */
public class EqualsAndAnotherEqualsTest {
    public static void main(String[] args) {
        String a = new String("121");
        String b = new String("121");
        System.out.println(a == b) ;//== 比较地址
        System.out.println(a.equals(b));//equals 根据覆写情况而定 String显然覆写了
    }
}
