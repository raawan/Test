package com.sky.shoppingcart;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartTest {

    @Test
    public void GIVEN_OneHeadphoneInShoppingCart_THEN_DiscountedPriceShouldBe_105() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        shoppingCart.addItem(new ShoppingItem("Headphones"));
        shoppingCart.applyPromotions();
        assertTrue(new BigDecimal("105.00").equals(shoppingCart.getDiscountedPriceForItem("Headphones")));
    }

    @Test
    public void GIVEN__OneHeadphone_AND_OneSpeaker_THEN_DiscountedPriceForHeadphoneShouldBe_105_DoscountedPriceForSpeakerShouldBe_59dot5() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        shoppingCart.addItem(new ShoppingItem("Headphones"),new ShoppingItem("Speakers"));
        shoppingCart.applyPromotions();
        assertTrue(new BigDecimal("105.00").equals(shoppingCart.getDiscountedPriceForItem("Headphones")));
        assertTrue(new BigDecimal("59.50").equals(shoppingCart.getDiscountedPriceForItem("Speakers")));
    }

    @Test
    public void GIVEN_TwoHeadphone_And_oneSpeaker_THEN_HEadephoneDiscountedPriceSHouldBe_210_SpeakerDiscountedPriceShouldBe_59dot5() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        shoppingCart.addItem(new ShoppingItem("Headphones",2),new ShoppingItem("Speakers"));
        shoppingCart.applyPromotions();
        assertTrue(new BigDecimal("210.00").equals(shoppingCart.getDiscountedPriceForItem("Headphones")));
        assertTrue(new BigDecimal("59.50").equals(shoppingCart.getDiscountedPriceForItem("Speakers")));
    }

    @Test
    public void GIVEN_TwoAAABatteries_THEN_QuantityShouldIncreaseBy_1() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        shoppingCart.addItem(new ShoppingItem("AAA_Batteries",2));
        shoppingCart.applyPromotions();
        assertEquals(3,shoppingCart.getItem("AAA_Batteries").getQuantity());
    }

    @Test
    public void GIVEN_FiveAAABatteries_THEN_QuantityShouldBeIncreaseBy_2(){
        ShoppingCart shoppingCart =  new ShoppingCart();
        shoppingCart.addItem(new ShoppingItem("AAA_Batteries",5));
        shoppingCart.applyPromotions();
        assertEquals(7,shoppingCart.getItem("AAA_Batteries").getQuantity());
    }
}
