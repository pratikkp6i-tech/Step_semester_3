package polymorphism.practice_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PublicTransportFareCalculator {

    static abstract class Transport {
        abstract double fare(double distance, double peakFactor);
    }

    static class Bus extends Transport {
        @Override double fare(double distance, double peakFactor) {
            double fare = 2.0 + 0.10 * distance;
            return Math.min(fare, 10.0);
        }
    }

    static class Train extends Transport {
        @Override double fare(double distance, double peakFactor) {
            return 3.0 + 0.15 * distance;
        }
    }

    static class Metro extends Transport {
        @Override double fare(double distance, double peakFactor) {
            return (1.50 + 0.20 * distance) * peakFactor;
        }
    }

    static Map<String, Transport> transportTypes = new HashMap<>();
    static {
        transportTypes.put("BUS", new Bus());
        transportTypes.put("TRAIN", new Train());
        transportTypes.put("METRO", new Metro());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);
            double peakFactor = (parts.length > 2) ? Double.parseDouble(parts[2]) : 1.0;

            Transport transport = transportTypes.get(type);
            double fare = transport.fare(distance, peakFactor);
            total += fare;

            System.out.printf("%s: %.2f%n", type, fare);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
