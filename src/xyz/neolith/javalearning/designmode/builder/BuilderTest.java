package xyz.neolith.javalearning.designmode.builder;

/**
 * @author sunlggggg
 * @date 2018/4/10
 */
public class BuilderTest {
    public static void main(String[] args) {
        Student student = new StudentBuilder()
                .setAge(18)
                .setName("sun lg")
                .setSubject("math")
                .build();
        System.out.println(student);
    }
}
