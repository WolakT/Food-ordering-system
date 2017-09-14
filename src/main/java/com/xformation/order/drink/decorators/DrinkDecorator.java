package com.xformation.order.drink.decorators;

import com.xformation.order.drink.Drink;

import java.math.BigDecimal;

/**
 * Created by WolakT on 2017-09-12.
 */
public abstract class DrinkDecorator implements Drink {
    protected Drink drink;

    public DrinkDecorator(Drink drink){
        this.drink = drink;
    }

    @Override
    public BigDecimal getPrice() {
        return drink.getPrice();
    }

    @Override
    public String getName() {
        return drink.getName();
    }
}
