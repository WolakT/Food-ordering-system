package com.xformation.order.meal;

import com.xformation.order.Orderable;

import java.math.BigDecimal;

/**
 * Created by WolakT on 2017-09-12.
 */
public class PolishMeal implements Orderable {

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(29.99);
    }

    @Override
    public String getName() {
        return "Grilled pork with mushrooms " + "\n" + "Cheesecake";
    }
}
