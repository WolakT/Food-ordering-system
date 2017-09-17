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

public class Demo {

    public static void main(String[] args) {

        UserMenu userMenu = new UserMenu();
        userMenu.start();

    }
}
