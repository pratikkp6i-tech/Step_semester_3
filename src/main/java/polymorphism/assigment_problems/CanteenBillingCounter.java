package polymorphism.assigment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CanteenBillingCounter {

    static abstract class Customer {
        abstract double finalAmount(double billAmount);
    }

    static class Student extends Customer {
        @Override double finalAmount(double billAmount) { return billAmount * 0.90; }
    }

    static class Staff extends Customer {
        @Override double finalAmount(double billAmount) { return billAmount * 0.95; }
    }

    static class Guest extends Customer {
        @Override double finalAmount(double billAmount) { return billAmount + 10; }
    }

    static Map<String, Customer> customerTypes = new HashMap<>();
    static {
        customerTypes.put("STUDENT", new Student());
        customerTypes.put("STAFF", new Staff());
        customerTypes.put("GUEST", new Guest());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            Customer customer = customerTypes.get(type);
            double finalAmount = customer.finalAmount(amount);
            total += finalAmount;

            System.out.printf("%s: %.2f%n", type, finalAmount);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
