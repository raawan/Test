package com.sky.shoppingcart;

import java.math.BigDecimal;

/**
 * Created by Minal.Fulzele on 15/10/2018.
 */
public class Itemfactory {

    public static Item createItem(String name) {
        switch (name) {
            case "Headphones" : return new Item("HeadPhones","Audio",150.00);
            case "Speakers" : return new Item("Speakers","Audio",85.00);
            case "AAA_Batteries" : return new Item("AAA_Batteries","Power",0.85);
            case "Protein_Bars" : return new Item("Protein_Bars","Food",25.00);
            default:throw new RuntimeException("No such product");
        }
    }
}
