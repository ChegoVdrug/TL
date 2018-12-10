package org.coffee.shop.coffee;

import org.coffee.shop.components.CoffeeComponent;

public interface Coffee {
    void addComponent(CoffeeComponent component);

    void printComponents();

    int getWater();

    int getCoffee();


    int getSugar();

    int getMilk();

    void setSugar(int sugarCount);
}

