package com.xformation;

import com.xformation.order.drink.Drink;
import com.xformation.order.Order;
import com.xformation.order.drink.Cola;
import com.xformation.order.drink.Water;
import com.xformation.order.drink.decorators.Ice;
import com.xformation.order.drink.decorators.Lemon;
import com.xformation.order.meal.ItalianMeal;
import com.xformation.order.meal.MexicanMeal;
import com.xformation.order.meal.PolishMeal;

public class Main {

    public static void main(String[] args) {

        Order order = new Order();
        PolishMeal polishMeal = new PolishMeal();
        MexicanMeal mexicanMeal = new MexicanMeal();
        ItalianMeal italianMeal = new ItalianMeal();
        order.add(mexicanMeal);
        order.add(polishMeal);

        Drink drink = new Lemon(new Ice(new Cola()));
        order.add(drink);
        Drink drink2 = new Lemon(new Water());
        order.add(drink2);

        System.out.println(order.getName());
        System.out.printf("Total Payable: %.2f\n",order.getPrice());
    }
}
