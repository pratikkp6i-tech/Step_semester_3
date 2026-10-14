package abstraction.assigment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class HomeApplianceEnergyReport {

    interface SaverMode {
        default double applySaver(double units) {
            return units * 0.75;
        }
    }

    static abstract class Appliance {
        abstract double powerW();

        double units(int hours) {
            return powerW() * hours / 1000.0;
        }
    }

    static class Fridge extends Appliance {
        @Override double powerW() { return 150.0; }
    }

    static class AC extends Appliance implements SaverMode {
        @Override double powerW() { return 1500.0; }
    }

    static class TV extends Appliance {
        @Override double powerW() { return 100.0; }
    }

    static class Washer extends Appliance implements SaverMode {
        @Override double powerW() { return 500.0; }
    }

    static Map<String, Supplier<Appliance>> applianceTypes = new HashMap<>();
    static {
        applianceTypes.put("FRIDGE", Fridge::new);
        applianceTypes.put("AC", AC::new);
        applianceTypes.put("TV", TV::new);
        applianceTypes.put("WASHER", Washer::new);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int hours = Integer.parseInt(parts[1]);
            boolean saverRequested = parts.length > 2 && parts[2].equalsIgnoreCase("SAVER");

            Appliance appliance = applianceTypes.get(type).get();
            double units = appliance.units(hours);

            if (saverRequested) {
                if (appliance instanceof SaverMode) {
                    units = ((SaverMode) appliance).applySaver(units);
                } else {
                    System.out.println(type + ": saver mode not supported");
                    continue;
                }
            }

            double cost = units * 8.0;
            totalCost += cost;
            System.out.printf("%s: Units=%.2f Cost=%.2f%n", type, units, cost);
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
