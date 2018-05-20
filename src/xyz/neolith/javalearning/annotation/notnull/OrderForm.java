package xyz.neolith.javalearning.annotation.notnull;

import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/05/14
 */
public class OrderForm {
    private Person buyer;
    private List<String> goods;
    private int allPrice;

    public Person getBuyer() {
        return buyer;
    }

    public void setBuyer(Person buyer) {
        this.buyer = buyer;
    }

    public List<String> getGoods() {
        return goods;
    }

    public void setGoods(List<String> goods) {
        this.goods = goods;
    }

    public int getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(int allPrice) {
        this.allPrice = allPrice;
    }
}
