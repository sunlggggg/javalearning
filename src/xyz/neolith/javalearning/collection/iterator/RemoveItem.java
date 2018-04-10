package xyz.neolith.javalearning.collection.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/3/28
 */
public class RemoveItem {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if ("2".equals(temp)) {
                a.remove(temp);
            }
        }
    }
}
