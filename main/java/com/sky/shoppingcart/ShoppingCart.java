package com.sky.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    /*
    Assuming the names of the products are unique based on the given data
     */
    public Item getItem(String name) {
        return items.stream()
                .filter(item -> item.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item does not exist"));
    }

    public void getDiscountedPrice() {

        items.stream().filter(item -> item.getType().equalsIgnoreCase("Audio"))
                .forEach(item -> item.setDiscountedPrice(
                        Optional.of(
                                item.getPrice().multiply(new BigDecimal("0.70").multiply(new BigDecimal(item.getQuantity()))))
                        )
                );

    }

    public BigDecimal getDiscountedPriceForItem(Item item) {
        return  items.stream().filter(item1 -> item1.getName().equalsIgnoreCase(item.getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item does not exist"))
                .getDiscountedPrice()
                .orElseGet(() -> new BigDecimal("0.00"));
    }
}
