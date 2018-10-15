package com.sky.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ShoppingCart {
    private List<ShoppingItem> items;

    public void addItem(ShoppingItem... shoppingItems) {
        if (items == null) {
            items = new ArrayList<ShoppingItem>();
        }
        items.addAll(Arrays.asList(shoppingItems));
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

    public void applyPromotions() {

        items.stream().filter(item -> item.getItem().getType().equalsIgnoreCase("Audio"))
                .forEach(item -> item.setDiscountPrice(
                        Optional.of(
                                item.getItem().getPrice().multiply(new BigDecimal("0.70").multiply(new BigDecimal(item.getQuantity()))))
                        )
                );

        items.stream().filter(item -> item.getItem().getName().equalsIgnoreCase("AAA_Batteries"))
                .forEach(item ->  item.setQuantity(3));

    }

    public BigDecimal getDiscountedPriceForItem(String itemName) {
        return items.stream().filter(item1 -> item1.getItem().getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item does not exist"))
                .getDiscountPrice()
                .orElseGet(() -> new BigDecimal("0.00"));
    }
}
