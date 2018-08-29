package xyz.neolith.javalearning.ref;

/**
 * @author sunligang
 * @date 2018/06/28
 */
public class StaticPoolTest {

        public static void main(String[] args){
            String str1 = new StringBuilder("计算").append("机软件").toString();
            System.out.println(str1.intern() == str1);

            String str2 = new StringBuilder("ja").append("va").toString();
            System.out.println(str2.intern() == str2);
        }
}
