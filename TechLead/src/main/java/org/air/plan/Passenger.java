package org.air.plan;

public class Passenger extends Carryable {
    private int weight = 80;
    private String name;

    Passenger(String name) {
        setName(name);
        setID();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    int GetWeight() {
        return weight;
    }
}
