package org.kostia.part2;

import java.util.Objects;

public abstract class Vehicle implements Taxable, Comparable<Vehicle> {

    protected final double basePrice;
    protected final String name;
    protected final String country;

    public Vehicle(double basePrice, String name, String country) {
        if( Double.compare(basePrice, 0.0) <= 0 ){
            throw new IllegalArgumentException("Price can't be negative or Zero: " + basePrice);
        }
        if( name == null ){
            throw new IllegalArgumentException("null 'name' detected");
        }
        if( country == null ){
            throw new IllegalArgumentException("null 'country' detected");
        }
        if( country.length() != 2){
            throw new IllegalArgumentException("incorrect 'country' code detected: " + country);
        }

        this.basePrice = basePrice;
        this.name = name;
        this.country = country;
    }

    @Override
    public double computeVat() {
        return basePrice * 0.19;
    }

    @Override
    public double computeTotalTax() {
        return computeVat() + computeRoadTax() + computeCustomTax();
    }

    @Override
    public double computeCustomTax() {
        if(Country.Romania.getCode().equalsIgnoreCase(country)){
            return 0.0;
        }

        return basePrice * 0.1;
    }

    @Override
    public int compareTo(Vehicle other) {
        // -1, 0, 1
        int totalTaxCmp = Double.compare(computeTotalTax(), other.computeTotalTax());

        if( totalTaxCmp != 0 ){
            return totalTaxCmp;
        }

        return -Double.compare(basePrice, other.basePrice);
    }

    @Override
    public String toString() {
        return "name=" + name  + "," +
                " basePrice=" + basePrice +
                   '\'' +
                ", country='" + country +
                '}';
    }
}
