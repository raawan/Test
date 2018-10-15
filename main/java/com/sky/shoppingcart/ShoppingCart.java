package com.sky.shoppingcart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class ShoppingCart {
    private List<ShoppingItem> items;

    public void addItem(ShoppingItem... shoppingItems) {
        if (items == null) {
            items = new ArrayList<>();
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

    private void applyPromotions() {

        items.stream().filter(item -> item.getItem().getType().equalsIgnoreCase("Audio"))
                .forEach(this::discountThirtyPercentPromotion);

        items.stream().filter(item -> item.getItem().getName().equalsIgnoreCase("AAA_Batteries"))
                .forEach(this::threeForThePriceOfTwoPromotion);

    }

    /*
    Assumption:
        the batteries added on top of added batteries by customer, they are not readjusted to the existing set.
        For ex: if 6 batteries bought, the customer will get additional 3 batteries. Its not like they will be charge for 4 batteries and remaining 2
        will be free.
     */
    private void threeForThePriceOfTwoPromotion(ShoppingItem item) {
        item.setQuantity(item.getQuantity() + item.getQuantity()/2);
    }

    private void discountThirtyPercentPromotion(ShoppingItem item) {
        item.setDiscountPrice(
                Optional.of(
                        item.getItem()
                                .getPrice()
                                .multiply(new BigDecimal("0.70")).setScale(2,RoundingMode.HALF_UP)
                )
        );
    }

    public BigDecimal getDiscountedPriceForItem(String itemName) {
        return items.stream().filter(item1 -> item1.getItem().getName().equalsIgnoreCase(itemName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item does not exist"))
                .getDiscountPrice()
                .orElseGet(() -> new BigDecimal("0.00"));
    }

    public void calculateItemCostBeforePromotion(ShoppingItem item) {
        item.getItem()
                .setPrice(item.getItem()
                        .getPrice()
                        .multiply(
                                new BigDecimal(item.getQuantity())).setScale(2, RoundingMode.HALF_UP)
                );
    }

    public void calculateCost() {
        items.stream().filter(item -> item.getQuantity()>1)
                .forEach(this::calculateItemCostBeforePromotion);
        this.applyPromotions();
    }

    public void printShoppingCart() {
        items.stream().forEach(item ->
        {
            System.out.println("name:"+item.getItem().getName());
            System.out.println("type:"+item.getItem().getType());
            System.out.println("original price:"+item.getItem().getPrice());
            System.out.println("discounted price:"+item.getDiscountPrice());
            System.out.println("final quantity:"+item.getQuantity());
            System.out.println("----------------------------");
        });
    }
}
