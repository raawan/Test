package com.sky.shoppingcart;

import java.math.BigDecimal;

public class Item {
    private final String name;
    private final String type;
    private BigDecimal price;


    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Item(String name, String type, BigDecimal price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }


}
