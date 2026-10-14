package abstraction.assigment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MovieTicketCounter {

    static final double CONVENIENCE_FEE = 20.0;

    static abstract class Ticket {
        abstract double price();

        double amount(int count) {
            return (price() + CONVENIENCE_FEE) * count;
        }
    }

    static class Regular extends Ticket {
        @Override double price() { return 150.0; }
    }

    static class Premium extends Ticket {
        @Override double price() { return 250.0; }
    }

    static class Recliner extends Ticket {
        @Override double price() { return 400.0; }
    }

    static Map<String, Ticket> seatTypes = new HashMap<>();
    static {
        seatTypes.put("REGULAR", new Regular());
        seatTypes.put("PREMIUM", new Premium());
        seatTypes.put("RECLINER", new Recliner());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String seat = parts[0];
            int count = Integer.parseInt(parts[1]);

            Ticket ticket = seatTypes.get(seat);
            double amount = ticket.amount(count);
            total += amount;

            System.out.printf("%s: %.2f%n", seat, amount);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
