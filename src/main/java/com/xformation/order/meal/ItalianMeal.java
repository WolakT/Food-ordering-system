package com.xformation.order.meal;

import com.xformation.order.Orderable;

import java.math.BigDecimal;

/**
 * Created by WolakT on 2017-09-12.
 */
public class ItalianMeal implements Orderable {
    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(24.99);
    }

    @Override
    public String getName() {
        return "Pizza " + "\n" + "Tiramisu";
    }
}
