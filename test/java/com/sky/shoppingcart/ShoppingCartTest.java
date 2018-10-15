package com.sky.shoppingcart;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartTest {

    @Test
    public void GIVEN_OneHeadphoneInShoppingCart_THEN_DiscountedPriceShouldBe_105() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        Item item = Itemfactory.createItem("Headphones");
        shoppingCart.addItem(item);
        shoppingCart.getDiscountedPrice();
        assertTrue(new BigDecimal("105.00").equals(shoppingCart.getDiscountedPriceForItem(item)));
    }

    @Test
    public void GIVEN__OneHeadphone_AND_OneSpeaker_THEN_DiscountedPriceForHeadphoneShouldBe_105_DoscountedPriceForSpeakerShouldBe_59dot5() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        Item item1 = Itemfactory.createItem("Headphones");
        Item item2 = Itemfactory.createItem("Speakers");
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);
        shoppingCart.getDiscountedPrice();
        assertTrue(new BigDecimal("105.00").equals(shoppingCart.getDiscountedPriceForItem(item1)));
        assertTrue(new BigDecimal("59.50").equals(shoppingCart.getDiscountedPriceForItem(item2)));
    }

    @Test
    public void GIVEn_TwoHeadphone_And_oneSpeaker_THEN_HEadephoneDiscountedPriceSHouldBe_210_SpeakerDiscountedPriceShouldBe_59dot5() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        Item item = Itemfactory.createItem("Headphones");
        item.setQuantity(2);
        shoppingCart.addItem(item);
        Item item1 = Itemfactory.createItem("Speakers");
        shoppingCart.addItem(item1);
        shoppingCart.getDiscountedPrice();
        assertTrue(new BigDecimal("210.00").equals(shoppingCart.getDiscountedPriceForItem(item)));
        assertTrue(new BigDecimal("59.50").equals(shoppingCart.getDiscountedPriceForItem(item1)));
    }

}
