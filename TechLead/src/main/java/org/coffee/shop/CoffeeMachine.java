package org.coffee.shop;

import org.coffee.shop.coffee.*;
import org.coffee.shop.components.CoffeeComponent;
import org.coffee.shop.components.Milk;
import org.coffee.shop.components.Sugar;

public class CoffeeMachine {

    private int countOfMilk = 0;
    CoffeeComponent milk = new Milk();
    CoffeeComponent sugar = new Sugar();

    public int getMilk() {
        return countOfMilk;
    }

    public void setMilk(int milkForCappuccino) {
        this.countOfMilk = milkForCappuccino;
    }

    public Coffee prepareCoffee(CoffeType type, int sugarCount) {
        //Добавить приготовление американо
        switch (type) {
            case ESPRESSO:
                EspressoCoffee espresso = new EspressoCoffee();
                espresso.setSugar(sugarCount);

                //добавить сахар, кофе, воду
                return espresso;
            case CAPPUCCINO:
                Coffee cappuchino = new CappuchinoCoffee();
                for (int i = 0; i < countOfMilk; i++) cappuchino.addComponent(milk);
                for (int i = 0; i < sugarCount; i++) {
                    cappuchino.addComponent(sugar);

                }

                //создать кофе
                //добавить молоко, сколько указано в поле класса
                //добавить сахар, кофе, воду
                return cappuchino;
            case AMERICANO:
                Coffee americano = new AmericanoCoffee();
                for (int i = 0; i < sugarCount; i++) {
                    americano.addComponent(sugar);

                }
                //создать кофе
                //добавить молоко, сколько указано в поле класса
                //добавить сахар, кофе, воду
                return americano;
            default:
                return null;
        }
    }
}
