package com.company;
//inheritance it extends from the class 'vessel'
public class RoRo extends Vessel {
    private int numberOfCars;
    private int numberOfTrucks;

    public RoRo(int capacity) {
        super(capacity);
    }

    @Override
    public void loadingCargo(int number, String unit) {
        if (unit.equals("car")) {
            this.numberOfCars = number;
            System.out.println(number + " cars loaded.");
        } else if (unit.equals("truck")) {
            this.numberOfTrucks = number;
            System.out.println(number + " trucks loaded.");
        } else {
            System.out.println("Invalid unit. Please use car or truck.");
        }
    }

    @Override
    public double loadFraction() {
        return ((double) numberOfCars + numberOfTrucks) / capacity;
    }
}