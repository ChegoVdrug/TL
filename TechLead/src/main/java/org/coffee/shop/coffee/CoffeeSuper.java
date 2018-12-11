package org.coffee.shop.coffee;

import org.coffee.shop.components.ComponentType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CoffeeSuper {

    void printAllComponentTypes(Map<ComponentType, Integer> unicComponents, CoffeType cofeeType) {
        System.out.println(cofeeType + ": {");
        System.out.println("Cofee " + unicComponents.get(ComponentType.COFFEE));
        System.out.println("Water " + unicComponents.get(ComponentType.WATER));
        System.out.println("Sugar " + unicComponents.get(ComponentType.SUGAR));
        System.out.println("Milk " + unicComponents.get(ComponentType.MILK));
        System.out.println("}");
    }

    Integer getComponentCountAllTypes(ComponentType componentType, CoffeType coffeType, List<ComponentType> components) {
        System.out.println(componentType  + " в " + coffeType.toString() + " = " + createReceiptMap(components).get(componentType));
        System.out.println();
        return createReceiptMap(components).get(componentType);
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
