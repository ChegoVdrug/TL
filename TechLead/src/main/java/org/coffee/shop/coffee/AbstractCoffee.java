package org.coffee.shop.coffee;

import org.coffee.shop.components.ComponentType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractCoffee implements Coffee{

    void printAllComponentTypes(Map<ComponentType, Integer> unicComponents, CoffeType cofeeType) {

 /*       Object[] possibleValues = ComponentType.class.getEnumConstants();
        System.out.println("---------------------\n" + possibleValues[0]);
        System.out.println( possibleValues[1]);
       // enumValue.getE
*/
        for (Map.Entry<ComponentType, Integer> entry : unicComponents.entrySet()) {
            System.out.println("Компонент =  " + entry.getKey() + " Количество = " + entry.getValue());
        }
  /*      System.out.println(changeCase(cofeeType.toString()) + ": {");
        System.out.println("Coffee " + unicComponents.get(ComponentType.COFFEE));
        System.out.println("Water " + unicComponents.get(ComponentType.WATER));
        System.out.println("Sugar " + unicComponents.get(ComponentType.SUGAR));
        System.out.println("Milk " + unicComponents.get(ComponentType.MILK));
        System.out.println("}");
*/    }

    Integer getComponentCountAllTypes(ComponentType componentType, CoffeType coffeType, List<ComponentType> components) {
        System.out.println(changeCase(componentType.toString())  + " в " + changeCase(coffeType.toString()) + " = " + createReceiptMap(components).get(componentType));
        System.out.println();
        return createReceiptMap(components).get(componentType);
    }
   String changeCase(String word){
        return (word.substring(0,1)+((word.substring(1,word.length())).toLowerCase()));
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

    @Override
    public void addComponent(ComponentType component) {

    }

    @Override
    public void printComponents() {

    }

    @Override
    public int getWater() {
        return 0;
    }

    @Override
    public int getCoffee() {
        return 0;
    }

    @Override
    public int getMilk() {
        return 0;
    }

    @Override
    public Integer getComponentCount(ComponentType componentType) {
        return null;
    }
}
