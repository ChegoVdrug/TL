package org.coffee.shop;

import org.coffee.shop.coffee.CoffeType;
import org.coffee.shop.coffee.Coffee;

public class Application {

    public static void main(String[] args) {
        CoffeeMachine machine1 = new CoffeeMachine();
        machine1.setMilk(1);

        CoffeeMachine machine2 = new CoffeeMachine();
        machine2.setMilk(8);

        Coffee espresso = machine1.prepareCoffee(CoffeType.ESPRESSO, 3);
        espresso.printComponents();
        //Сделать и распечатать капучино

        Coffee cappuccino = machine1.prepareCoffee(CoffeType.CAPPUCCINO, 1);
        cappuccino.printComponents();


        Coffee americano = machine1.prepareCoffee(CoffeType.AMERICANO, 2);
        americano.printComponents();

        Coffee cappuccino2 = machine2.prepareCoffee(CoffeType.CAPPUCCINO, 1);
        cappuccino2.printComponents();


        //Подумать, как сломать машину
/*
        Coffee rusiano = machine1.prepareCoffee(CoffeType.RUSIANO, 2);
        rusiano.printComponents();
*/


    }
}