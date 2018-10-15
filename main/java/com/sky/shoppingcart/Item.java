package com.sky.shoppingcart;

import java.math.BigDecimal;

public class Item {
    private String itemname;
    private BigDecimal discountedPrice;

    public void setDiscountedPrice(BigDecimal discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public Item(String itemName) {
            this.itemname=itemName;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public BigDecimal getDiscountedPrice() {
        return new BigDecimal("105");
    }
}
