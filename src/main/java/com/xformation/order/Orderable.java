package com.xformation.order;

import java.math.BigDecimal;

/**
 * Created by WolakT on 2017-09-12.
 */
public interface Orderable {

    public BigDecimal getPrice();

    public String getName();
}
