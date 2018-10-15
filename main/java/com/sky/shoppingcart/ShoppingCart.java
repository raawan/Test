package com.sky.shoppingcart;

/**
 * Created by Minal.Fulzele on 15/10/2018.
 */
public class ShoppingCart {
    private Item item;
    public void addItem(Item item) {
        this.item = item;
    }

    public Item getItem(String name) {
        return this.item;
    }
}
