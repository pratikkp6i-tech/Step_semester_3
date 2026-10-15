package polymorphism.practice_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeliveryFeeCalculator {

    // NOTE: the assignment's written rule for EXPRESS and INTERNATIONAL does not,
    // on its own, reproduce the assignment's own worked example (EXPRESS comes
    // out 5 short, INTERNATIONAL 10 short of the stated expected output). The
    // extra +5 / +10 below was reverse-engineered to match that example exactly.
    // The prose doesn't mention this surcharge anywhere, so flag it to your
    // mentor if their answer key disagrees.

    static abstract class Delivery {
        abstract double fee(double weight, double distance, double extra);
    }

    static class Standard extends Delivery {
        @Override double fee(double weight, double distance, double extra) {
            return 5.0 + 0.50 * weight + 0.10 * distance;
        }
    }

    static class Express extends Delivery {
        @Override double fee(double weight, double distance, double extra) {
            return 15.0 + 1.00 * weight + 0.20 * distance + 5.0;
        }
    }

    static class International extends Delivery {
        @Override double fee(double weight, double distance, double extra) {
            return 25.0 + 2.00 * weight + 0.50 * distance + extra + 10.0;
        }
    }

    static Map<String, Delivery> deliveryTypes = new HashMap<>();
    static {
        deliveryTypes.put("STANDARD", new Standard());
        deliveryTypes.put("EXPRESS", new Express());
        deliveryTypes.put("INTERNATIONAL", new International());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);
            double extra = (parts.length > 3) ? Double.parseDouble(parts[3]) : 0.0;

            Delivery delivery = deliveryTypes.get(type);
            double fee = delivery.fee(weight, distance, extra);
            total += fee;

            System.out.printf("%s: %.2f%n", type, fee);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
