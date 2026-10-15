package polymorphism.practice_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PaymentSystemFeeCalculation {

    static abstract class Payment {
        abstract double adjustedAmount(double amount);
    }

    static class Card extends Payment {
        @Override double adjustedAmount(double amount) { return amount * 1.02; }
    }

    static class Wallet extends Payment {
        @Override double adjustedAmount(double amount) { return amount * 1.01; }
    }

    static class BankTransfer extends Payment {
        @Override double adjustedAmount(double amount) { return amount; }
    }

    static Map<String, Payment> paymentTypes = new HashMap<>();
    static {
        paymentTypes.put("CARD", new Card());
        paymentTypes.put("WALLET", new Wallet());
        paymentTypes.put("BANKTRANSFER", new BankTransfer());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            Payment payment = paymentTypes.get(type);
            double adjusted = payment.adjustedAmount(amount);
            total += adjusted;

            System.out.printf("%s: %.2f%n", type, adjusted);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
