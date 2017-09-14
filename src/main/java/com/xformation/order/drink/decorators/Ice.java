package com.xformation.order.drink.decorators;

import com.xformation.order.drink.Drink;

/**
 * Created by WolakT on 2017-09-12.
 */
public class Ice extends DrinkDecorator {

    public Ice(Drink drink) {
        super(drink);
    }


    @Override
    public String getName() {
        return super.getName() + " with ice";
    }
}
