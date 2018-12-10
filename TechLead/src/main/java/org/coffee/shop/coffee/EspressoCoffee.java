package org.coffee.shop.coffee;

import org.coffee.shop.CoffeeMachine;
import org.coffee.shop.components.CofeComp;
import org.coffee.shop.components.CoffeeComponent;
import org.coffee.shop.components.Water;

import java.util.ArrayList;
import java.util.List;

public class EspressoCoffee implements Coffee {

    private List<CoffeeComponent> components = new ArrayList<>();
    private CoffeeComponent water = new Water();
    private CoffeeComponent cofii = new CofeComp();
    private CoffeeComponent sugar = new CofeComp();
    private static int countOfWater = 1;
    private static int countOfCoffee = 2;
    public int countOfSugar = 0;

    public int getWater() {
        return countOfWater;
    }
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
        for (int i = 1; i <= countOfWater; i++) components.add(water);
        for (int i = 1; i <= countOfCoffee; i++) components.add(cofii);
        for (int i = 1; i <= countOfSugar; i++) components.add(sugar);
    }

    @Override
    public void addComponent(CoffeeComponent component) {
        components.add(component);
    }

    @Override
    public void printComponents() { //мой вариант распечатки состава намба ту.
        System.out.println("Espresso: {");

        System.out.println("Coffee "+ getCoffee());
        System.out.println("Water "+ getWater());
        System.out.println("Sugar "+ getSugar());
        System.out.println("}");
        //Распечатать в виде: 2 сахара, 3 молока
    }
}
