package org.air.plan;

public class Test {
    public static void main(String[] args) {
        AirPlane airPlane = new AirPlane();

        airPlane.AddCarryable(new Passenger("Valentina"));
        airPlane.AddCarryable(new Passenger("Egor Andreevich"));
        airPlane.AddCarryable(new Passenger("Vasiliy"));
        airPlane.AddCarryable(new Passenger("Petr"));
        airPlane.AddCarryable(new Passenger("Nikonor"));

        airPlane.AddCarryable(new Luggage());
        airPlane.AddCarryable(new Luggage());
        airPlane.AddCarryable(new Luggage());
        airPlane.AddCarryable(new Luggage());

        airPlane.printPassengers();
        airPlane.printLuggage();
    }
}
