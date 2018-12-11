package org.coffee.shop.coffee;

import org.coffee.shop.components.ComponentType;

public interface Coffee {
    void addComponent(ComponentType component);

    void printComponents();

    int getWater();

    int getCoffee();

    int getMilk();

    Integer getComponentCount(ComponentType componentType);

//    Integer getComponentCount(ComponentType componentType, CoffeType coffeType);
}

