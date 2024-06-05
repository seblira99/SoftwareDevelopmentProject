package com.company;
//inheritance it extends from the class 'vessel'
public class ContainerVessel extends Vessel {
    private int numberOfContainers;

    public ContainerVessel(int capacity) {
        super(capacity);
    }
    // loading variables in main
    @Override
    public void loadingCargo(int number, String unit) {
        if (unit.equals("TEU")) {
            this.numberOfContainers = number;
            System.out.println(number + " containers loaded.");
        } else {
            System.out.println("Invalid unit. Please use TEU.");
        }
    }
    // calculating loadFraction
    @Override
    public double loadFraction() {
        return (double) numberOfContainers / capacity;
    }
}

