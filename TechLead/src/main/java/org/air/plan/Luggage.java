package org.air.plan;

class Luggage extends Carryable{
    private int weight = 20;

    Luggage() {
        setID();
    }

    @Override
    int GetWeight() {
        return weight;
    }
}
