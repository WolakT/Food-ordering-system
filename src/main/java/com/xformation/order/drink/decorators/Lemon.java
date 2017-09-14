package com.xformation.order.drink.decorators;

import com.xformation.order.drink.Drink;

import java.math.BigDecimal;

/**
 * Created by WolakT on 2017-09-12.
 */
public class Lemon extends DrinkDecorator {

    public Lemon(Drink drink){
        super(drink);
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice();
    }

    @Override
    public String getName() {
        return super.getName() + " with lemon";
    }
}
