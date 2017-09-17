package com.xformation;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.xformation.order.Order;
import com.xformation.order.drink.Cola;
import com.xformation.order.drink.Drink;
import com.xformation.order.drink.Water;
import com.xformation.order.drink.decorators.Ice;
import com.xformation.order.drink.decorators.Lemon;
import com.xformation.order.meal.ItalianMeal;
import com.xformation.order.meal.MexicanMeal;
import com.xformation.order.meal.PolishMeal;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by WolakT on 2017-09-17.
 */
public class UserMenu {
    public static final String PATTERN_MEAL = "[pim]";
    public static final String PATTERN_DRINK = "[cwnx]";
    public static final String PATTERN_EXIT = "[x]";
    public static final String PATTERN_DECORATOR = "[iln]?[iln]";
    public static final String GREETING = "Welcome to food ordering system!";
    public static final String MENU_HEADER = "What would you like to order? Enter first letter of the meal";
    private boolean exitProgram;
    private Scanner scanner;
    private Order order;

    public UserMenu() {
        System.out.println(GREETING);
        scanner = new Scanner(System.in);

    }

    public void start() {
        test:
        while (!exitProgram) {
            order = new Order();
            showMenu();

            String userInput = scanner.next();
            if (isInputValid(userInput, PATTERN_EXIT)) {
                exitProgram = true;
                continue;
            }
            while (!isInputValid(userInput, PATTERN_MEAL)) {
                System.out.println("Input invalid choose again or Exit with X");
                showMenu();
                userInput = scanner.next();
                if (isInputValid(userInput, PATTERN_EXIT)) {
                    exitProgram = true;
                    continue test;
                }

            }
            switch (userInput.toLowerCase()) {
                case "p":
                    order.add(new PolishMeal());
                    break;
                case "i":
                    order.add(new ItalianMeal());
                    break;
                case "m":
                    order.add(new MexicanMeal());
                    break;
            }

            System.out.println("Would you like a drink? Cola or Water? Select C or W; N for nothing");
            String drinkInput = scanner.next();
            if (isInputValid(drinkInput, PATTERN_EXIT)) {
                exitProgram = true;
                continue;
            }
            while (!isInputValid(drinkInput, PATTERN_DRINK)) {
                System.out.println("Input invalid choose again or press x to cancel order, N for no drink");
                drinkInput = scanner.next();
                if (isInputValid(userInput, PATTERN_EXIT)) {
                    exitProgram = true;
                    continue test;
                }
            }
            if (!drinkInput.equals("n")) {
                Drink drink = makeDrink(drinkInput);
                System.out.println("Would you like Lemon or/and Ice? Select L or/and I or N for nothing");
                String decoratorInput = scanner.next();
                if (isInputValid(decoratorInput, PATTERN_EXIT)) {
                    exitProgram = true;
                    continue;
                }
                while (!isInputValid(decoratorInput, PATTERN_DECORATOR)) {
                    System.out.println("Input invalid choose again or press x to cancel order, N for just drink");
                    decoratorInput = scanner.next();
                    if (isInputValid(decoratorInput, PATTERN_EXIT)) {
                        exitProgram = true;
                        continue test;
                    }
                }
                if (!decoratorInput.equals("n")) {
                    if (decoratorInput.split("").length == 2) {
                        Drink finalDrink = new Lemon(new Ice(drink));
                        order.add(finalDrink);
                    } else if (decoratorInput.equalsIgnoreCase("i")) {
                        Drink finalDrink = new Ice(drink);
                        order.add(finalDrink);
                    } else if (decoratorInput.equalsIgnoreCase("l")) {
                        Drink finalDrink = new Lemon(drink);
                        order.add(finalDrink);
                    }
                } else order.add(drink);
            }
            summarizeOrder();
        }


    }


    private void showCousineList() {
        System.out.println("Select \"I\"for Italian meal:");
        System.out.println(new ItalianMeal().getName());
        System.out.println("Select \"P\"for Polish meal:");
        System.out.println(new PolishMeal().getName());
        System.out.println("Select \"M\"for Mexican meal:");
        System.out.println(new MexicanMeal().getName());

    }

    private boolean isInputValid(String input, String regex) {
        if (input.toLowerCase().matches(regex)) {
            return true;
        } else return false;

    }

    private void showMenu() {
        System.out.println(MENU_HEADER);
        showCousineList();
    }

    private Drink makeDrink(String drinkInput) {
        switch (drinkInput) {

            case "c":
                Drink cola = new Cola();
                return cola;
            case "w":
                Drink water = new Water();
                return water;
        }
        return null;
    }

    private void summarizeOrder() {
        System.out.println(order.getName());
        System.out.println("Total amount payable:");
        System.out.println(order.getPrice() + "\n");
    }

}
