package org.coffee.shop;

import org.coffee.shop.coffee.CoffeType;
import org.coffee.shop.coffee.Coffee;
import org.coffee.shop.components.ComponentType;

public class Application {

    public static void main(String[] args) {
        CoffeeMachine machine1 = new CoffeeMachine();
        //machine1.setMilk(3);

        CoffeeMachine machine2 = new CoffeeMachine();
       // machine2.setMilk(0);

        Coffee espresso = machine1.prepareCoffee(CoffeType.ESPRESSO, 2);
        espresso.printComponents();
        espresso.getComponentCount(ComponentType.MILK);
        espresso.getComponentCount(ComponentType.SUGAR, CoffeType.ESPRESSO);

        Coffee cappuccino = machine1.prepareCoffee(CoffeType.CAPPUCCINO, 4);
        cappuccino.printComponents();
        cappuccino.getComponentCount(ComponentType.MILK, CoffeType.CAPPUCCINO);
        cappuccino.getComponentCount(ComponentType.COFFEE, CoffeType.CAPPUCCINO);


        Coffee americano = machine1.prepareCoffee(CoffeType.AMERICANO, 6);
        americano.printComponents();
        americano.getComponentCount(ComponentType.COFFEE);
        americano.getComponentCount(ComponentType.MILK, CoffeType.AMERICANO);



        Coffee cappuccino2 = machine2.prepareCoffee(CoffeType.CAPPUCCINO, 8);
        cappuccino2.printComponents();


        //Подумать, как сломать машину
/*
        Coffee rusiano = machine1.prepareCoffee(CoffeType.RUSIANO, 2);
        rusiano.printComponents();
*/


    }
}