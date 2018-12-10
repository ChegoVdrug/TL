package org.coffee.shop.coffee;

import org.coffee.shop.components.CofeComp;
import org.coffee.shop.components.CoffeeComponent;
import org.coffee.shop.components.Water;

import java.util.ArrayList;
import java.util.List;

public class EspressoCoffee implements Coffee {

    private List<CoffeeComponent> components = new ArrayList<>();
    private CoffeeComponent water = new Water();
    private CoffeeComponent cofii = new CofeComp();
    private static int standartPartWater = 1;
    private static int standartCofeComp = 2;

    public EspressoCoffee (){
        for (int i = 1; i <= standartPartWater; i++) components.add(water);
        for (int i = 1; i <= standartCofeComp; i++) components.add(cofii);
    }

    @Override
    public void addComponent(CoffeeComponent component) {
        components.add(component);
    }

    @Override
    public void printComponents() {
        System.out.println("Espresso: {");
        for (CoffeeComponent component : components) {
            System.out.println("\t"+component);
        }
        System.out.println("}");
        //Распечатать в виде: 2 сахара, 3 молока
    }
}
