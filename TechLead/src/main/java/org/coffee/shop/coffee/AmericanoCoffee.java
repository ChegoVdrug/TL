package org.coffee.shop.coffee;

import org.coffee.shop.components.CoffeeComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmericanoCoffee implements Coffee {

    private static int countOfWater = 5;
    private static int countOfCoffee = 3;
    private List<CoffeeComponent> components = new ArrayList<>();
    private int countOfSugar = 0;

    public AmericanoCoffee() {
    }

    @Override
    public void addComponent(CoffeeComponent component) {
        components.add(component);
    }

    @Override
    public void printComponents() {
        System.out.println("Americano: {");
        Map<String, Integer> unicComponents = new HashMap<>();

        for (CoffeeComponent component : components) {
            Integer oldCount = unicComponents.get(component.toString());
            if (oldCount == null) {

                oldCount = 0;
            }
            unicComponents.put(component.toString(), oldCount + 1);
        }
        System.out.println("Cofee " + unicComponents.get("Cava"));
        System.out.println("Water " + unicComponents.get("Water"));
        System.out.println("Sugar " + unicComponents.get("Sugar"));
        System.out.println();
        System.out.println("}");
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
    public int getSugar() {
        return countOfSugar;
    }

    public void setSugar(int countOfSugar) {
       this.countOfSugar = countOfSugar;
    }
}
