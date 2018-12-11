package org.coffee.shop.coffee;

import org.coffee.shop.components.ComponentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmericanoCoffee extends CoffeeSuper implements Coffee {

    private static int countOfWater = 5;
    private static int countOfCoffee = 3;
    private List<ComponentType> components = new ArrayList<ComponentType>();

    public AmericanoCoffee() {
    }

    @Override
    public void addComponent(ComponentType component) {
        components.add(component);
    }

    @Override
    public void printComponents() {
        System.out.println("Americano: {");
        printAllComponentTypes(createReceiptMap(components));

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
       // Map<ComponentType, Integer> unicComponents = createReceiptMap(components);
        System.out.println(componentType  + " = " + createReceiptMap(components).get(componentType));
        System.out.println();
        return createReceiptMap(components).get(componentType);
    }

    @Override
    public Integer getComponentCount(ComponentType componentType, CoffeType coffeType) {
        System.out.println(componentType  + " в " + coffeType.toString() + " = " + createReceiptMap(components).get(componentType));
        System.out.println();
        return createReceiptMap(components).get(componentType);
    }
}
