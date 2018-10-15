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

    @Test
    public void GIVEN__OneHeadphone_AND_OneSpeaker_THEN_DiscountedPriceForHeadphoneShouldBe_105_DoscountedPriceForSpeakerShouldBe_59dot5() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        shoppingCart.addItem(new Item("Headphones","Audio",150.00));
        shoppingCart.addItem(new Item("Speakers","Audio",85.00));
        BigDecimal discountedPriceForHEadPhone = shoppingCart.getItem("Headphones").getDiscountedPrice();
        BigDecimal discountedPriceForSpeaker = shoppingCart.getItem("Speakers").getDiscountedPrice();
        assertTrue(new BigDecimal("105").equals(discountedPriceForHEadPhone));
        assertTrue(new BigDecimal("59.5").equals(discountedPriceForSpeaker));

    }

    @Test
    public void GIVEn_TwoHeadphone_And_oneSpeaker_THEN_HEadephoneDiscountedPriceSHouldBe_210_SpeakerDiscountedPriceShouldBe_59dot5() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        Item item = new Item("Headphones", "Audio", 150.00);
        item.setQuantity(2);
        shoppingCart.addItem(item);
        shoppingCart.addItem(new Item("Speakers","Audio",85.00));
        BigDecimal discountedPriceForHEadPhone = shoppingCart.getItem("Headphones").getDiscountedPrice();
        BigDecimal discountedPriceForSpeaker = shoppingCart.getItem("Speakers").getDiscountedPrice();
        assertTrue(new BigDecimal("210").equals(discountedPriceForHEadPhone));
        assertTrue(new BigDecimal("59.5").equals(discountedPriceForSpeaker));
    }
}
