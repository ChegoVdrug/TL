package org.coffee.shop.coffee;

import Coffe.CofeeType;
import org.coffee.shop.components.ComponentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmericanoCoffee extends CoffeeSuper implements Coffee {

    private static int countOfWater = 5;
    private static int countOfCoffee = 3;
    private List<ComponentType> components = new ArrayList<ComponentType>();


    @Override
    public void addComponent(ComponentType component) {
        components.add(component);
    }

    @Override
    public void printComponents() {
        printAllComponentTypes(createReceiptMap(components), CofeeType.AMERICANO);

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
