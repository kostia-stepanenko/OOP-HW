package org.kostia.part2;

import java.util.Arrays;

public class Part2and3Main {

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Bus(500.00,"Mazda5", Country.USA.getCode()),
                new Minibus(300.00,"Lexus2",Country.Romania.getCode()),
                new Truck(400.00,"BMW8",Country.Spain.getCode()),
                new Truck(100.00,"Land Rover",Country.Romania.getCode()),
        };

        Arrays.sort(vehicles);

        for(Vehicle curVehicle: vehicles ){

            String type;

            if( curVehicle instanceof  Bus ){
                type = "Bus";
            }
            else if( curVehicle instanceof  Truck ){
                type = "Truck";
            }
            else if(curVehicle instanceof  Minibus ){
                type = "Minibus";
            }
            else {
                throw new IllegalStateException("Undefined type detected");
            }

            System.out.printf("type: %s, name: %s, country: %s, basePrice: %.2f, total tax: %.2f %n", type,
                    curVehicle.name, curVehicle.country,curVehicle.basePrice, curVehicle.computeTotalTax());
        }
    }
}
