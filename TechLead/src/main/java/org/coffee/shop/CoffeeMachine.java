package org.coffee.shop;

import org.coffee.shop.coffee.*;
import org.coffee.shop.components.*;

public class CoffeeMachine {

    public Coffee prepareCoffee(CoffeType type, int sugarCount) {
        switch (type) {
            case ESPRESSO:
                EspressoCoffee espresso = new EspressoCoffee();
                createCofeBase(espresso,sugarCount);
                return espresso;

            case CAPPUCCINO:
                CappuccinoCoffee cappuccino = new CappuccinoCoffee();
                createCofeBase(cappuccino,sugarCount);
                return cappuccino;

            case AMERICANO:
                AmericanoCoffee americano = new AmericanoCoffee();
                createCofeBase(americano,sugarCount);
                return americano;

            default:
                return null;
        }
    }

    private void createCofeBase(Coffee coffee, int countOfSugar) {
        coffee.setSugar(countOfSugar);
        for (int i = 0; i < coffee.getMilk(); i++){
            coffee.addComponent(new Milk());
        }
        for (int i = 0; i < coffee.getSugar(); i++) {
            coffee.addComponent(new Sugar());
        }
        for (int i = 0; i < coffee.getWater(); i++) {
            coffee.addComponent(new Water());
        }
        for (int i = 0; i < coffee.getCoffee(); i++) {
            coffee.addComponent(new CofeComp());
        }
    }
}
