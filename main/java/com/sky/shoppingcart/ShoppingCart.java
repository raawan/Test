package com.sky.shoppingcart;

public class ShoppingCart {
    private Item item;
    ShoppingCart(Item item) {
        this.item=item;
    }

    public Item getItem(String name) {
        return item;
    }
}
