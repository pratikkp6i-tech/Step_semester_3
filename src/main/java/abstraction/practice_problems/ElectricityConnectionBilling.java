package abstraction.practice_problems;

import java.util.Scanner;

public class ElectricityConnectionBilling {

    static abstract class Connection {
        abstract double bill(int units);
    }

    static class Home extends Connection {
        @Override double bill(int units) {
            if (units <= 100) return units * 5.0;
            return 100 * 5.0 + (units - 100) * 7.0;
        }
    }

    static class Shop extends Connection {
        @Override double bill(int units) { return units * 8.0 + 100.0; }
    }

    static class Factory extends Connection {
        @Override double bill(int units) { return Math.max(units * 6.0, 1000.0); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);

            Connection connection;
            if (type.equals("HOME")) connection = new Home();
            else if (type.equals("SHOP")) connection = new Shop();
            else connection = new Factory();

            double bill = connection.bill(units);
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
