package org.coffee.shop.coffee;

import org.coffee.shop.components.ComponentType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeSuper {

    void printAllComponentTypes(Map<ComponentType, Integer> unicComponents) {
        System.out.println("Cofee " + unicComponents.get(ComponentType.COFFEE));
        System.out.println("Water " + unicComponents.get(ComponentType.WATER));
        System.out.println("Sugar " + unicComponents.get(ComponentType.SUGAR));
        System.out.println("Milk " + unicComponents.get(ComponentType.MILK));
        System.out.println("}");
    }

    Map<ComponentType, Integer> createReceiptMap(List<ComponentType> components) {
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
