package com.xformation.order;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WolakT on 2017-09-12.
 */
public class Order implements Orderable {
    List<Orderable> orderedItems = new ArrayList<>();

    @Override
    public BigDecimal getPrice() {
        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < orderedItems.size(); i++) {
            sum = sum.add(orderedItems.get(i).getPrice());

        }
        return sum.setScale(2, BigDecimal.ROUND_HALF_UP);
    }


    @Override
    public String getName() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < orderedItems.size(); i++) {
            sb.append(orderedItems.get(i).getName() + "\n");
        }
        return sb.toString();
    }

    public void add(Orderable order) {
        orderedItems.add(order);
    }

    public void remove(Orderable order) {
        orderedItems.remove(order);
    }


}
