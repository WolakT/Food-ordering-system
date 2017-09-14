package com.xformation.order;

import com.xformation.order.drink.Cola;
import com.xformation.order.drink.Drink;
import com.xformation.order.drink.decorators.Lemon;
import com.xformation.order.meal.ItalianMeal;
import com.xformation.order.meal.MexicanMeal;
import com.xformation.order.meal.PolishMeal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by WolakT on 2017-09-14.
 */
public class OrderTest {

    private Order testOrder;
    public static final String ITALIAN_MEAL = "Pizza \nTiramisu\n";
    public static final double POLISH_MEAL_PRICE = 29.99;
    private ItalianMeal italianMeal;
    private PolishMeal polishMeal;
    private MexicanMeal mexicanMeal;
    private Drink drink;


    @Before
    public void setUp(){
        testOrder = new Order();
       italianMeal= new ItalianMeal();
       polishMeal = new PolishMeal();
       mexicanMeal = new MexicanMeal();
       drink = new Lemon(new Cola());
    }

    @Test
    public void shouldReturnPriceForPolishMeal(){
        PolishMeal polishMeal = new PolishMeal();
        testOrder.add(polishMeal);

        Assert.assertEquals(new BigDecimal(POLISH_MEAL_PRICE, new MathContext(5)),  testOrder.getPrice());
    }

    @Test
    public void shouldReturnNameForItalianMeal(){

        order(italianMeal);

        Assert.assertEquals(ITALIAN_MEAL, testOrder.getName());
    }

    @Test
    public void shouldCalculateTotalSumForOrder(){
        order(polishMeal,mexicanMeal,italianMeal, drink);

        BigDecimal expectedPrice = new BigDecimal(91.98, new MathContext(5));

        Assert.assertEquals(expectedPrice, testOrder.getPrice());
    }

    private void order(Orderable... orders){
        for (Orderable order : orders     ) {
            testOrder.add(order);
        }

    }

}