package com.sky.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCart {
    private List<ShoppingItem> items;

    public void addItem(ShoppingItem item) {
        if (items == null) {
            items = new ArrayList<ShoppingItem>();
        }
        items.add(item);
    }

    /*
    Assuming the names of the products are unique based on the given data
     */
    public ShoppingItem getItem(String name) {
        return items.stream()
                .filter(item -> item.getItem().getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item does not exist"));
    }

    public void getDiscountedPrice() {

        items.stream().filter(item -> item.getItem().getType().equalsIgnoreCase("Audio"))
                .forEach(item -> item.setDiscountPrice(
                        Optional.of(
                                item.getItem().getPrice().multiply(new BigDecimal("0.70").multiply(new BigDecimal(item.getQuantity()))))
                        )
                );

    }

    public BigDecimal getDiscountedPriceForItem(ShoppingItem item) {
        return items.stream().filter(item1 -> item1.getItem().getName().equalsIgnoreCase(item.getItem().getName()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item does not exist"))
                .getDiscountPrice()
                .orElseGet(() -> new BigDecimal("0.00"));
    }
}
