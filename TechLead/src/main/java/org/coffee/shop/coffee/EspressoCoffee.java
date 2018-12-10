package org.coffee.shop.coffee;

import org.coffee.shop.components.CoffeeComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EspressoCoffee implements Coffee {

    private List<CoffeeComponent> components = new ArrayList<>();
    private static int countOfWater = 1;
    private static int countOfCoffee = 2;
    public int countOfSugar = 0;

    @Override
    public int getWater() {
        return countOfWater;
    }
    @Override
    public int getCoffee() {
        return countOfCoffee;
    }
    public int getSugar() {
        return countOfSugar;
    }
    public void setSugar(int sugarCount) {
        countOfSugar = sugarCount;
    }
    public EspressoCoffee (){
    }

    @Override
    public void addComponent(CoffeeComponent component) {
        components.add(component);
    }

    @Override
    public void printComponents() {
        System.out.println("Espresso: {");

        Map<String, Integer> unicComponents = new HashMap<>();

        for ( CoffeeComponent component: components ) {
            Integer oldCount = unicComponents.get(component.toString());
            if ( oldCount == null ) {
                oldCount = 0;
            }
            unicComponents.put(component.toString(), oldCount + 1);
        }
        System.out.println("Coffee " + unicComponents.get("Cava"));
        System.out.println("Water " + unicComponents.get("Water"));
        System.out.println("Sugar " + unicComponents.get("Sugar"));
        System.out.println();
    }


    public void printComponentsAccrossGet() {
        System.out.println("Espresso(GET): {");

        System.out.println("Coffee "+ getCoffee());
        System.out.println("Water "+ getWater());
        System.out.println("Sugar "+ getSugar());
        System.out.println("}");
        //Распечатать в виде: 2 сахара, 3 молока
    }
}
