package org.coffee.shop.coffee;

import org.coffee.shop.components.CofeComp;
import org.coffee.shop.components.CoffeeComponent;
import org.coffee.shop.components.Water;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CappuchinoCoffee implements Coffee {

    private List<CoffeeComponent> components = new ArrayList<>();
    private CoffeeComponent water = new Water();
    private CoffeeComponent cofii = new CofeComp();
    private static int standartPartWater = 1;
    private static int standartCofeComp = 2;
    static int countMilk = 1;

    public void setCountMilk(int countMilk) {
        CappuchinoCoffee.countMilk = countMilk;
    }


    public CappuchinoCoffee() {

        for (int i = 1; i <= standartPartWater; i++) components.add(water);
        for (int i = 1; i <= standartCofeComp; i++) components.add(cofii);
    }

    @Override
    public void addComponent(CoffeeComponent component) {
        components.add(component);
    }

    @Override
    public void printComponents() {
        System.out.println("Cappuchino: {");
        Map<String, Integer> unicComponents = new HashMap<String, Integer>(); // вариант из интернетов, разбираюсь

        for ( CoffeeComponent component: components ) {
            Integer oldCount = unicComponents.get(component.toString());
            if ( oldCount == null ) {
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
}
