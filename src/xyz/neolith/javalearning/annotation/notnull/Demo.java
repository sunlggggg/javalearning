package xyz.neolith.javalearning.annotation.notnull;

/**
 * @author sunlggggg
 * @date 2018/05/14
 */
public class Demo {
    public static void main(String[] args) {
        Person person = null;
        Market market = new Market();
        market.generate(person,null);
    }
}
