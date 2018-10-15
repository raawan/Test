package com.sky.shoppingcart;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartTest {

    @Test
    public void GIVEN__OneHeadphoneInShoppingCart__THEN__DiscountedPriceShouldBe_105() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        shoppingCart.addItem(new ShoppingItem("Headphones"));
        shoppingCart.applyPromotions();
        assertTrue(new BigDecimal("105.00").equals(shoppingCart.getDiscountedPriceForItem("Headphones")));
    }

    @Test
    public void GIVEN__OneHeadphone_AND_OneSpeaker__THEN__DiscountedPriceForHeadphoneShouldBe_105_DiscountedPriceForSpeakerShouldBe_59dot5() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        shoppingCart.addItem(new ShoppingItem("Headphones"),new ShoppingItem("Speakers"));
        shoppingCart.applyPromotions();
        assertTrue(new BigDecimal("105.00").equals(shoppingCart.getDiscountedPriceForItem("Headphones")));
        assertTrue(new BigDecimal("59.50").equals(shoppingCart.getDiscountedPriceForItem("Speakers")));
    }

    @Test
    public void GIVEN__TwoHeadphone_And_OneSpeaker__THEN__HeadephoneDiscountedPriceShouldBe_210_SpeakerDiscountedPriceShouldBe_59dot5() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        shoppingCart.addItem(new ShoppingItem("Headphones",2),new ShoppingItem("Speakers"));
        shoppingCart.applyPromotions();
        assertTrue(new BigDecimal("210.00").equals(shoppingCart.getDiscountedPriceForItem("Headphones")));
        assertTrue(new BigDecimal("59.50").equals(shoppingCart.getDiscountedPriceForItem("Speakers")));
    }

    @Test
    public void GIVEN__TwoAAABatteries__THEN__QuantityShouldIncreaseBy_1() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        shoppingCart.addItem(new ShoppingItem("AAA_Batteries",2));
        shoppingCart.applyPromotions();
        assertEquals(3,shoppingCart.getItem("AAA_Batteries").getQuantity());
    }

    @Test
    public void GIVEN__FiveAAABatteries__THEN__QuantityShouldBeIncreaseBy_2(){
        ShoppingCart shoppingCart =  new ShoppingCart();
        shoppingCart.addItem(new ShoppingItem("AAA_Batteries",5));
        shoppingCart.applyPromotions();
        assertEquals(7,shoppingCart.getItem("AAA_Batteries").getQuantity());
    }

    @Test
    public void GIVEN__1Speaker_5AAABatteries_2ProteinBars__THEN__theShoppingCartShouldContain_1Speaker_7AAABatteries_2ProteinBars_And_SpeakerDiscountedPrice() {
        ShoppingCart shoppingCart =  new ShoppingCart();
        shoppingCart.addItem(new ShoppingItem("Speakers"));
        shoppingCart.addItem(new ShoppingItem("AAA_Batteries",5));
        shoppingCart.addItem(new ShoppingItem("Protein_Bars",2));
        shoppingCart.applyPromotions();

        shoppingCart.calculateCost();

        assertTrue(shoppingCart.getItem("Protein_Bars").getItem().getPrice().equals(new BigDecimal(50.00)));

    }
}
