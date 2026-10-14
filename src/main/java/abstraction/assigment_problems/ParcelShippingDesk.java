package abstraction.assigment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParcelShippingDesk {

    interface Insurable {
        default double insurance(double declaredValue) {
            return declaredValue * 0.02;
        }
    }

    static abstract class Parcel {
        abstract double charge(double weightKg);

        double baseCharge(double weightKg) {
            return 40.0 + 10.0 * weightKg;
        }
    }

    static class Standard extends Parcel {
        @Override double charge(double weightKg) { return baseCharge(weightKg); }
    }

    static class Express extends Parcel implements Insurable {
        @Override double charge(double weightKg) { return 80.0 + 15.0 * weightKg; }
    }

    static class Fragile extends Parcel implements Insurable {
        @Override double charge(double weightKg) { return baseCharge(weightKg) + 50.0; }
    }

    static Map<String, Parcel> parcelTypes = new HashMap<>();
    static {
        parcelTypes.put("STANDARD", new Standard());
        parcelTypes.put("EXPRESS", new Express());
        parcelTypes.put("FRAGILE", new Fragile());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weightKg = Double.parseDouble(parts[1]);
            double declaredValue = Double.parseDouble(parts[2]);

            Parcel parcel = parcelTypes.get(type);
            double charge = parcel.charge(weightKg);
            double insurance = (parcel instanceof Insurable) ? ((Insurable) parcel).insurance(declaredValue) : 0.0;
            double total = charge + insurance;
            grandTotal += total;

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n", type, charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}
