package org.kostia.part2;

public class Bus extends Vehicle{

    public Bus(double basePrice, String name, String country) {
        super(basePrice, name, country);
    }

    @Override
    public double computeRoadTax() {
        return basePrice * 0.04;
    }

}
