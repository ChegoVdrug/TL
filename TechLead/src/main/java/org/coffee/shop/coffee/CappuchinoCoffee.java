package org.coffee.shop.coffee;

import org.coffee.shop.components.CoffeeComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CappuchinoCoffee implements Coffee {

    private static int countOfWater = 1;
    private static int countOfCoffee = 2;
    private List<CoffeeComponent> components = new ArrayList<>();

    public CappuchinoCoffee() {
    }

    @Override
    public void addComponent(CoffeeComponent component) {
        components.add(component);
    }

    @Override
    public void printComponents() {
        System.out.println("Cappuchino: {");
        Map<String, Integer> unicComponents = new HashMap<>();

        for (CoffeeComponent component : components) {
            Integer oldCount = unicComponents.get(component.toString());
            if (oldCount == null) {
                oldCount = 0;
            }
            unicComponents.put(component.toString(), oldCount + 1);
        }
        System.out.println("Cava " + unicComponents.get("Cava"));
        System.out.println("Water " + unicComponents.get("Water"));
        System.out.println("Sugar " + unicComponents.get("Sugar"));
        System.out.println("Milk " + unicComponents.get("Milk"));
        System.out.println();

    }

    @Override
    public int getWater() {
        return countOfWater;
    }

    @Override
    public int getCoffee() {
        return countOfCoffee;
    }
}
