package com.github.sunlggggg.javalearning.annotation.notnull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunlggggg
 * @date 2018/05/14
 */
public class Market {
    private Map<String, Integer> allGoods = new HashMap<>();
    int generate( Person person, List<String> purchasedGoods) {
        OrderForm orderForm = new OrderForm();
        orderForm.setBuyer(person);
        orderForm.setGoods(purchasedGoods);
        int price = 0 ;
        for(String good: purchasedGoods ){
            price += allGoods.get(good);
        }
        orderForm.setAllPrice(price);
        return price;
    }
}
