package com.company;

public class Vessel {
    protected int capacity;

    public Vessel(int capacity) {
        this.capacity = capacity;
    }

    public void loadingCargo(int number, String unit) {
        System.out.println("Loading cargo...");
    }

    public double loadFraction() {
        return 0.0;
    }
}
