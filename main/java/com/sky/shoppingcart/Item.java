package com.sky.shoppingcart;

import java.math.BigDecimal;

/**
 * Created by Minal.Fulzele on 15/10/2018.
 */
public class Item {
    private String name;
    private String type;
    private BigDecimal price;
    public Item(String name, String type, double price) {
        this.name= name;
        this.type=type;
        this.price=new BigDecimal(price);
    }

    public BigDecimal getDiscountedPrice() {
        return null;
    }
}
