package org.coffee.shop.coffee;

import org.coffee.shop.components.ComponentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EspressoCoffee implements Coffee {

    private List<ComponentType> components = new ArrayList<ComponentType>();
    private static int countOfWater = 1;
    private static int countOfCoffee = 2;

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
       // Map<ComponentType,Integer> unicComponents = createReceiptMap();
        System.out.println(componentType  + " = " + createReceiptMap().get(componentType));
        System.out.println();
        return createReceiptMap().get(componentType);
    }



    public EspressoCoffee (){
    }

    @Override
    public void addComponent(ComponentType component) {
        components.add(component);
    }

    @Override
    public void printComponents() {
        System.out.println("Espresso: {");
        Map<ComponentType, Integer> unicComponents = createReceiptMap();
        System.out.println("Cofee " + unicComponents.get(ComponentType.COFFEE));
        System.out.println("Water " + unicComponents.get(ComponentType.WATER));
        System.out.println("Sugar " + unicComponents.get(ComponentType.SUGAR));
        System.out.println("}");
    }

    private Map<ComponentType,Integer> createReceiptMap() {
        Map<ComponentType, Integer> unicComponents = new HashMap<>();

        for (ComponentType component : components) {
            Integer oldCount = unicComponents.get(component);
            if (oldCount == null) {
                oldCount = 0;
            }
            unicComponents.put(component, oldCount + 1);
        }
        return unicComponents;
    }




}
