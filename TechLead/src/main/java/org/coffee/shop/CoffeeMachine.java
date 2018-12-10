package org.coffee.shop;

import org.coffee.shop.coffee.*;
import org.coffee.shop.components.*;

public class CoffeeMachine {

    public Coffee prepareCoffee(CoffeType type, int sugarCount) {
        switch (type) {
            case ESPRESSO:
                EspressoCoffee espresso = new EspressoCoffee();

                espresso.setSugar(sugarCount);

                for (int i = 0; i < espresso.getWater(); i++) {
                    espresso.addComponent(new Water());
                }
                for (int i = 0; i < espresso.getCoffee(); i++) {
                    espresso.addComponent(new CofeComp());
                }
                for (int i = 0; i < sugarCount; i++) {
                    espresso.addComponent(new Sugar());
                }
                return espresso;

            case CAPPUCCINO:
                CappuchinoCoffee cappuchino = new CappuchinoCoffee();
                for (int i = 0; i < cappuchino.getMilk(); i++){
                    cappuchino.addComponent(new Milk());
                }
                for (int i = 0; i < sugarCount; i++) {
                    cappuchino.addComponent(new Sugar());
                }
                for (int i = 0; i < cappuchino.getWater(); i++) {
                    cappuchino.addComponent(new Water());
                }
                for (int i = 0; i < cappuchino.getCoffee(); i++) {
                    cappuchino.addComponent(new CofeComp());
                }
                return cappuchino;

            case AMERICANO:
                Coffee americano = new AmericanoCoffee();
                for (int i = 0; i < sugarCount; i++) {
                    americano.addComponent(new Sugar());
                }
                for (int i = 0; i < americano.getWater(); i++) {
                    americano.addComponent(new Water());
                }
                for (int i = 0; i < americano.getCoffee(); i++) {
                    americano.addComponent(new CofeComp());
                }
                return americano;

            default:
                return null;
        }
    }
}
