package com.sky.shoppingcart;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartTest {

    @Test
    public void GIVEN_OneHeadphoneInShoppingCart_THEN_DiscountedPriceShouldBe_105() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        ShoppingItem item = new ShoppingItem("Headphones");
        shoppingCart.addItem(item);
        shoppingCart.applyPromotions();
        assertTrue(new BigDecimal("105.00").equals(shoppingCart.getDiscountedPriceForItem(item)));
    }

    @Test
    public void GIVEN__OneHeadphone_AND_OneSpeaker_THEN_DiscountedPriceForHeadphoneShouldBe_105_DoscountedPriceForSpeakerShouldBe_59dot5() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        ShoppingItem item1 = new ShoppingItem("Headphones");
        ShoppingItem item2 = new ShoppingItem("Speakers");
        shoppingCart.addItem(item1,item2);
        shoppingCart.applyPromotions();
        assertTrue(new BigDecimal("105.00").equals(shoppingCart.getDiscountedPriceForItem(item1)));
        assertTrue(new BigDecimal("59.50").equals(shoppingCart.getDiscountedPriceForItem(item2)));
    }

    @Test
    public void GIVEn_TwoHeadphone_And_oneSpeaker_THEN_HEadephoneDiscountedPriceSHouldBe_210_SpeakerDiscountedPriceShouldBe_59dot5() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        ShoppingItem item = new ShoppingItem("Headphones",2);
        ShoppingItem item1 = new ShoppingItem("Speakers");
        shoppingCart.addItem(item,item1);
        shoppingCart.applyPromotions();
        assertTrue(new BigDecimal("210.00").equals(shoppingCart.getDiscountedPriceForItem(item)));
        assertTrue(new BigDecimal("59.50").equals(shoppingCart.getDiscountedPriceForItem(item1)));
    }

}
