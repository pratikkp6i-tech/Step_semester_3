package abstraction.assigment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class CityCabFareMeter {

    interface NightService {
        default double applyNightSurcharge(double fare) {
            return fare * 1.20;
        }
    }

    static abstract class Cab {
        abstract double ratePerKm();

        double fare(double km) {
            return Math.max(km * ratePerKm(), 100.0);
        }
    }

    static class Mini extends Cab {
        @Override double ratePerKm() { return 10.0; }
    }

    static class Sedan extends Cab implements NightService {
        @Override double ratePerKm() { return 14.0; }
    }

    static class SUV extends Cab implements NightService {
        @Override double ratePerKm() { return 18.0; }
    }

    static Map<String, Supplier<Cab>> cabTypes = new HashMap<>();
    static {
        cabTypes.put("MINI", Mini::new);
        cabTypes.put("SEDAN", Sedan::new);
        cabTypes.put("SUV", SUV::new);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double km = Double.parseDouble(parts[1]);
            String time = parts[2];

            Cab cab = cabTypes.get(type).get();
            double fare = cab.fare(km);

            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    fare = ((NightService) cab).applyNightSurcharge(fare);
                } else {
                    System.out.println(type + ": night service not available");
                    continue;
                }
            }

            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
