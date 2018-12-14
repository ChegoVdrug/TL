package org.air.plan;

import java.util.Random;

public abstract class Carryable {

    private int ID;

    abstract int GetWeight();

    int getID() {
        return ID;
    }

    public String getName() {
        return null;
    }

    void setID() {
        Random random = new Random();
        ID = random.nextInt(1000);
    }
    @Override
    public String toString() {
        return null;
           }

}
