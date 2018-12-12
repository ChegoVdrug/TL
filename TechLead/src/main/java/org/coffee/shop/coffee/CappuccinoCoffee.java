package org.coffee.shop.coffee;

import org.coffee.shop.components.ComponentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CappuccinoCoffee implements Coffee {

    private static int countOfWater = 1;
    private static int countOfCoffee = 2;
    private int countOfMilk = 1;
    private List<ComponentType> components = new ArrayList<ComponentType>();

    public CappuccinoCoffee() {
    }

    @Override
    public void addComponent(ComponentType component) {
        components.add(component);
    }

    @Override
    public void printComponents() {
        System.out.println("Cappuchino: {");

        Map<ComponentType, Integer> unicComponents = createReceiptMap();
        System.out.println("Cofee " + unicComponents.get(ComponentType.COFFEE));
        System.out.println("Water " + unicComponents.get(ComponentType.WATER));
        System.out.println("Sugar " + unicComponents.get(ComponentType.SUGAR));
        System.out.println("Milk " + unicComponents.get(ComponentType.MILK));
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

    @Override
    public int getWater() {
        return countOfWater;
    }
    @Override
    public int getCoffee() {
        return countOfCoffee;
    }
    public int setMilk(int newCount){
        return countOfMilk=newCount;
    }
    public int getMilk(){
        return countOfMilk;
    }

    @Override
    public Integer getComponentCount(ComponentType componentType) {
        Map<ComponentType, Integer> unicComponents = createReceiptMap();
        System.out.println(componentType  + " = " + unicComponents.get(componentType));
        System.out.println();
        return unicComponents.get(componentType);
    }

    public Integer getComponentCount(ComponentType componentType, CoffeType coffeType) {
        System.out.println(componentType  + " в " + coffeType.toString() + " = " + createReceiptMap().get(componentType));
        System.out.println();
        return createReceiptMap().get(componentType);
    }


}
