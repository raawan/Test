package com.sky.shoppingcart;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Minal.Fulzele on 15/10/2018.
 */
public class ShoppingCartTest {

    @Test
    public void GIVEN_OneHeadphoneInShoppingCart_THEN_DiscountedPriceShouldBe_105() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        shoppingCart.addItem(new Item("Headphones","Audio",150.00));
        BigDecimal discountedPrice = shoppingCart.getItem("Headphones").getDiscountedPrice();
        assertTrue(new BigDecimal("105").equals(discountedPrice));
    }


}
