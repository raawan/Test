package com.sky.shoppingcart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Minal.Fulzele on 15/10/2018.
 */
public class ShoppingCart {
    private List<Item> items;

    public void addItem(Item item) {
        if(items==null){
            items = new ArrayList<Item>();
        }
        items.add(item);
    }

    public Item getItem(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item does not exist"));
    }
}
