package com.sky.shoppingcart;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by Minal.Fulzele on 15/10/2018.
 */
public class Item {
    private String name;
    private String type;
    private BigDecimal price;
    private int quantity;
    private Optional<BigDecimal> discountedPrice;


    public int getQuantity() {
        if(quantity==0){
            return 1;
        }
        return quantity;
    }

    public Optional<BigDecimal> getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Optional<BigDecimal> discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Item(String name, String type, double price) {
        this.name= name;
        this.type=type;
        this.price=new BigDecimal(price);
    }



    public void setQuantity(int qty) {
        this.quantity = qty;
    }
}
