package org.coffee.shop;

import org.coffee.shop.coffee.CoffeType;
import org.coffee.shop.coffee.Coffee;

public class Application {

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.setMilk(2);

        Coffee espresso = machine.prepareCoffee(CoffeType.ESPRESSO, 3);
        espresso.printComponents();
        //Сделать и распечатать капучино

        Coffee cappuccino = machine.prepareCoffee(CoffeType.CAPPUCCINO, 1);
        cappuccino.printComponents();


        Coffee americano = machine.prepareCoffee(CoffeType.AMERICANO, 2);
        americano.printComponents();

        //Подумать, как сломать машину

    }

}
