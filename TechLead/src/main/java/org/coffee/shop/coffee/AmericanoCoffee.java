package org.coffee.shop.coffee;

import org.coffee.shop.components.CofeComp;
import org.coffee.shop.components.CoffeeComponent;
import org.coffee.shop.components.Water;

import java.util.ArrayList;
import java.util.List;

public class AmericanoCoffee implements Coffee {

    private List<CoffeeComponent> components = new ArrayList<>();
    private CoffeeComponent water = new Water();
    private CoffeeComponent cofii = new CofeComp();
    private static int standartPartWater = 5;
    private static int standartCofeComp = 3;

    public AmericanoCoffee() {

        for (int i = 1; i <= standartPartWater; i++) components.add(water);
        for (int i = 1; i <= standartCofeComp; i++) components.add(cofii);
    }

    @Override
    public void addComponent(CoffeeComponent component) {
        components.add(component);
    }

    @Override
    public void printComponents() {
        System.out.println("Americano: {");  //мой вариант, в целом работает, но выводит криво. надо довести до ума выведение только конечного количества, пока думаю
        String curName = "";
        String newName;
        int i = 0;
        for (CoffeeComponent component : components) {
            newName = component.toString();

            i++;
            if (newName != curName) {
                curName = newName;
                newName = "";
                System.out.println("\t" + component );
                   i = 1;
            }
            else {System.out.println(i);}
  //              i = 0;
        }

        System.out.println("}");
        //Распечатать в виде: 2 сахара, 3 молока
    }
}
