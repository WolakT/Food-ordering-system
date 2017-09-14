package com.xformation.order.meal;

import com.xformation.order.Orderable;

import java.math.BigDecimal;

/**
 * Created by WolakT on 2017-09-12.
 */
public class MexicanMeal implements Orderable {
    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(29.0);
    }

    @Override
    public String getName() {
        return "Chili con carne \nJericalla";
    }
}
