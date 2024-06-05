package com.company;
/*
1. vessel container (can carry n containers)
2. vessel tanker ( can carry 10 * n measured in m^3)
3. vessel roro (x lane meters can carry cars and trucks. car = 8m  truck = 30m)

 provide constructors for relevant classes and methods loadingCargo() and loadingFraction()
 - loadingCargo should take 2 parameters: a number and a String.
 (container vessel: Number of containers and a string "TEU")
 (Tanker vessel: number between 1-10 as a String)
 (Roro vessel: should be "car" or "truck")

 - loadFraction() should return a number between 0 and 1 to indicate how much of the capacity is used.
 (Tanker vessel: a compartment is in use if not empty)
 */

public class Main {
    public static void main(String[] args) {
        // Create a ContainerVessel object
        ContainerVessel containerVessel = new ContainerVessel(100);

        // Load cargo onto the container vessel
        containerVessel.loadingCargo(50, "TEU");
        //TEU = Twenty-foot Equivalent Units

        // Print the load fraction of the container vessel
        System.out.println("Load fraction: " + containerVessel.loadFraction());

        // Create a Tanker object
        Tanker tanker = new Tanker(500);

        // Load cargo onto the tanker
        tanker.loadingCargo(3, "1");
        tanker.loadingCargo(4, "5");
        tanker.loadingCargo(2, "10");

        // Print the load fraction of the tanker
        System.out.println("Load fraction: " + tanker.loadFraction());

        // Create a RoRo object
        RoRo roro = new RoRo(200);

        // Load cargo onto the RoRo
        roro.loadingCargo(80, "car");
        roro.loadingCargo(10, "truck");

        // Print the load fraction of the RoRo
        System.out.println("Load fraction: " + roro.loadFraction());
    }
}
