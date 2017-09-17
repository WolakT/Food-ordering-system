package com.xformation.order.drink;

import java.math.BigDecimal;

/**
 * Created by WolakT on 2017-09-12.
 */
public class Cola implements Drink {

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(8.0);
    }

    @Override
    public String getName() {
        return "Cola";

    }
}
