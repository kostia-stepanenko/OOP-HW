package org.kostia.part2;

public interface Taxable {

    double computeVat();
    double computeRoadTax();
    double computeCustomTax();
    double computeTotalTax();

}
