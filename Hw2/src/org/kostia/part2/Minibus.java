package org.kostia.part2;

public class Minibus extends Vehicle{

    public Minibus(double basePrice, String name, String country) {
        super(basePrice, name, country);
    }

    @Override
    public double computeRoadTax() {
        return basePrice * 0.03;
    }


}
