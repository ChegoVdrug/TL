package org.coffee.shop.coffee;

import org.coffee.shop.components.CoffeeComponent;

public interface Coffee {
    void addComponent(CoffeeComponent component);

    void printComponents();

    int getWater();

    int getCoffee();


}
