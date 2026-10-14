package polymorphism.assigment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CampusParkingChargeCalculator {

    static abstract class Vehicle {
        abstract double charge(int hours);
    }

    static class Bike extends Vehicle {
        @Override double charge(int hours) { return hours * 10.0; }
    }

    static class Car extends Vehicle {
        @Override double charge(int hours) {
            if (hours <= 1) return 30.0;
            return 30.0 + (hours - 1) * 20.0;
        }
    }

    static class Truck extends Vehicle {
        @Override double charge(int hours) {
            double amount = hours * 50.0;
            return Math.max(amount, 100.0);
        }
    }

    static Map<String, Vehicle> vehicleTypes = new HashMap<>();
    static {
        vehicleTypes.put("BIKE", new Bike());
        vehicleTypes.put("CAR", new Car());
        vehicleTypes.put("TRUCK", new Truck());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);

            Vehicle vehicle = vehicleTypes.get(type);
            double charge = vehicle.charge(hours);
            total += charge;

            System.out.printf("%s: %.2f%n", type, charge);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
