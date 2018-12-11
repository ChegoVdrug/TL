package org.coffee.shop.coffee;

import org.coffee.shop.components.ComponentType;

import java.util.ArrayList;
import java.util.List;

public class AmericanoCoffee extends CoffeeSuper implements Coffee {

    private static int countOfWater = 5;
    private static int countOfCoffee = 3;
    private List<ComponentType> components = new ArrayList<>();


    @Override
    public void addComponent(ComponentType component) {
        components.add(component);
    }

    @Override
    public void printComponents() {
        printAllComponentTypes(createReceiptMap(components), CoffeType.AMERICANO);

    }
    @Override
    public int getWater() {
        return countOfWater;
    }

    @Override
    public int getCoffee() {
        return countOfCoffee;
    }

    @Override
    public int getMilk() {
        return 0;
    }

    @Override
    public Integer getComponentCount(ComponentType componentType) {
        return getComponentCountAllTypes(componentType, CoffeType.AMERICANO, components);
    }


}
