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
                .forEach(this::discountThirtyPercentPromotion);

        items.stream().filter(item -> item.getItem().getName().equalsIgnoreCase("AAA_Batteries"))
                .forEach(this::threeForThePriceOfTwoPromotion);

    }

    /*
    Assumption:
        the batteries added on top of added batteries by cutomer, they are not readjusted to the existing set.
        For ex: if 6 batteries bought, the customer will get additional 3 batteries. Its not like they will be charge for 4 batteries and remaining 2
        will be free.
     */
    public void threeForThePriceOfTwoPromotion(ShoppingItem item) {
        item.setQuantity(item.getQuantity() + item.getQuantity()/2);
    }

    public void discountThirtyPercentPromotion(ShoppingItem item) {
        item.setDiscountPrice(
                Optional.of(
                        item.getItem().getPrice().multiply(new BigDecimal("0.70").multiply(new BigDecimal(item.getQuantity()))))
        );
    }

    public BigDecimal getDiscountedPriceForItem(String itemName) {
        return items.stream().filter(item1 -> item1.getItem().getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item does not exist"))
                .getDiscountPrice()
                .orElseGet(() -> new BigDecimal("0.00"));
    }

    public void calculateCost() {

    }
}
