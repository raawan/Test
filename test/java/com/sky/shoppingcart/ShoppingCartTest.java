package com.sky.shoppingcart;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Minal.Fulzele on 15/10/2018.
 */
public class ShoppingCartTest {

    @Test
    public void GIVEN_OneHeadphoneInShoppingCart_THEN_DiscountedPriceShouldBe_105() {
        ShoppingCart shoppingCart =  new ShoppingCart(new Item("Headphones"));
        BigDecimal discountedPrice = shoppingCart.getItem("Headphones").getDiscountedPrice();
        assertEquals(105,discountedPrice.doubleValue(),0);
    }
}
