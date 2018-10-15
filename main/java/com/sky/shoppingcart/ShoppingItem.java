package com.sky.shoppingcart;

import java.math.BigDecimal;
import java.util.Optional;

public class ShoppingItem {

    private final Item item;
    private final int quantity;
    private Optional<BigDecimal> discountPrice;

    public ShoppingItem(String itemName, int quantity) {
        this.item=Itemfactory.createItem(itemName);
        this.quantity=quantity;
    }
    public ShoppingItem(String itemName) {
        this(itemName,1);
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public Optional<BigDecimal> getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Optional<BigDecimal> discountPrice) {
        this.discountPrice = discountPrice;
    }
}
