package org.coffee.shop;

import org.coffee.shop.coffee.*;
import org.coffee.shop.components.*;

public class CoffeeMachine {

    public Coffee prepareCoffee(CoffeType type, int sugarCount) {
        switch (type) {
            case ESPRESSO:
                return createCofeBase(new EspressoCoffee(),sugarCount);

            case CAPPUCCINO:
                return createCofeBase(new CappuccinoCoffee(),sugarCount);

            case AMERICANO:
                return createCofeBase(new AmericanoCoffee(),sugarCount);

            default:
                return null;
        }
    }

    private Coffee createCofeBase(Coffee coffee, int countOfSugar) {


        for (int i = 0; i < coffee.getMilk(); i++){
            coffee.addComponent(ComponentType.MILK);
        }
        for (int i = 0; i < countOfSugar; i++) {
            coffee.addComponent(ComponentType.SUGAR);
        }
        for (int i = 0; i < coffee.getWater(); i++) {
            coffee.addComponent(ComponentType.WATER);
        }
        for (int i = 0; i < coffee.getCoffee(); i++) {
            coffee.addComponent(ComponentType.COFFEE);
        }

        return coffee;
    }

}
