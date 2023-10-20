package org.kostia.part2;

public class Truck extends Vehicle{

    public Truck(double basePrice, String name, String country) {
        super(basePrice, name, country);
    }

    @Override
    public double computeRoadTax() {
        return basePrice * 0.05;
    }
}
