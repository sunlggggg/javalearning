package xyz.neolith.javalearning.fp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List<Integer> n = Arrays.asList(1, 4, 20, 11);
        Comparator<Integer> c1 = Comparator.comparingInt(y -> y);
        Comparator<Integer> c2 = c1.reversed();
        System.out.println(n.stream().min(c1).get());
        System.out.println(n.stream().min(c2).get());
    }
}
