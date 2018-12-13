package org.air.plan;

import java.util.ArrayList;


class AirPlane {
    private static int totalWeight = 0;
    private ArrayList<Carryable> load = new ArrayList<>();

    void printPassengers() {
        System.out.println("\nPrint Passengers");
        for (Carryable aLoad : load) {
            if (aLoad instanceof Passenger)
                System.out.println(aLoad.toString());
        }
    }

    void printLuggage() {
        System.out.println("\nPrint Luggage");
        for (Carryable aLoad : load) {
            if (aLoad instanceof Luggage)
                System.out.println(aLoad.toString());
        }
    }

    void AddCarryable(Carryable carryable) throws Exception { //тоже про полиморфизм, instanceof
        if ((totalWeight + carryable.GetWeight()) <= 300) {
            totalWeight += carryable.GetWeight();
            load.add(carryable);
            System.out.println("New carryable: " + carryable.toString());

        } else System.out.println("Airplane Overloded. totalWeight " + totalWeight);
    }

 /*
    void AddCarryable(Carryable carryable) throws Exception { //тоже про полиморфизм, instanceOf
        if ((totalWeight + carryable.GetWeight()) <= 300) {
            totalWeight += carryable.GetWeight();

                if (carryable instanceof Passenger){ //   switch (carryable.getClass().getSimpleName()) {
                    System.out.println("Новый пассажир " + carryable.getName() + " ID_" + carryable.getID());
                    passengers.add(carryable);
                }
               else if (carryable instanceof Luggage)
                {  luggages.add((new Luggage()));
                    System.out.println("Luggage added.ID_" + carryable.getID());
            }
        } else System.out.println("Airplane Overloded. totalWeight " + totalWeight);
    }
    */
}
