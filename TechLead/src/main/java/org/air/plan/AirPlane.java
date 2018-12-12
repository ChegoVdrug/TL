package org.air.plan;

import java.util.ArrayList;

class AirPlane {
    private static int totalWeight = 0;
    private ArrayList<Carryable> passengers = new ArrayList<>();
    private ArrayList<Carryable> luggages = new ArrayList<>();

    void printPassengers() {
        System.out.println("\nPrint Passengers");
        for (Carryable passenger : passengers) {
            System.out.println(passenger.getName() + " " + passenger.getID());
        }
    }

    void printLuggage() {
        System.out.println("\nPrint Luggages");
        for (Carryable luggage : luggages) {
            System.out.println(luggage.getID());
        }
    }

    void AddCarryable(Carryable carryable) {
        if ((totalWeight + carryable.GetWeight()) <= 300) {
            totalWeight += carryable.GetWeight();
            switch (carryable.getClass().getSimpleName()) {
                case "Passenger":
                    System.out.println("Новый пассажир " + carryable.getName() + " ID_" + carryable.getID());
                    passengers.add(carryable);
                    break;
                case "Luggage":
                    luggages.add((new Luggage()));
                    System.out.println("Luggage added.ID_" + carryable.getID());
                    break;
            }
        } else System.out.println("Airplane Overloded. totalWeight " + totalWeight);
    }
}
