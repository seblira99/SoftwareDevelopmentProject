package com.company;
//inheritance it extends from the class 'vessel'
public class Tanker extends Vessel {
    private String[] compartments;

    public Tanker(int capacity) {
        super(capacity);
        compartments = new String[10];
    }

    @Override
    public void loadingCargo(int number, String unit) {
        int compartmentNumber = Integer.parseInt(unit);
        if (compartmentNumber >= 1 && compartmentNumber <= 10) {
            compartments[compartmentNumber - 1] = "occupied";
            System.out.println("Compartment " + compartmentNumber + " occupied.");
        } else {
            System.out.println("Invalid compartment number. Please use a number between 1 and 10.");
        }
    }

    @Override
    public double loadFraction() {
        int compartmentsInUse = 0;
        for (String compartment : compartments) {
            if (compartment != null && !compartment.isEmpty()) {
                compartmentsInUse++;
            }
        }
        return (double) compartmentsInUse / compartments.length;
    }
}