package com.sky.shoppingcart;

import java.math.BigDecimal;

class ItemFactory {

    public static Item createItem(String name) {
        switch (name) {
            case "Headphones" : return new Item("HeadPhones","Audio",new BigDecimal(150.00));
            case "Speakers" : return new Item("Speakers","Audio",new BigDecimal(85.00));
            case "AAA_Batteries" : return new Item("AAA_Batteries","Power",new BigDecimal(0.85));
            case "Protein_Bars" : return new Item("Protein_Bars","Food",new BigDecimal(25.00));
            default:throw new RuntimeException("No such product");
        }
    }
}
