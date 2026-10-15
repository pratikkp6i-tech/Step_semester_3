package abstraction.practice_problems;

import java.util.Scanner;

public class TravelBookingWithCommonFee {

    static final double BOOKING_FEE = 50.0;

    static abstract class Travel {
        abstract double baseFare(double distanceKm);

        double total(double distanceKm) {
            return baseFare(distanceKm) + BOOKING_FEE;
        }
    }

    static class Bus extends Travel {
        @Override double baseFare(double distanceKm) { return distanceKm * 2.0; }
    }

    static class Train extends Travel {
        @Override double baseFare(double distanceKm) { return distanceKm * 1.5; }
    }

    static class Flight extends Travel {
        @Override double baseFare(double distanceKm) { return 2500.0 + distanceKm * 4.0; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String mode = parts[0];
            double distance = Double.parseDouble(parts[1]);

            Travel travel;
            if (mode.equals("BUS")) travel = new Bus();
            else if (mode.equals("TRAIN")) travel = new Train();
            else travel = new Flight();

            double total = travel.total(distance);
            System.out.printf("%s: %.2f%n", mode, total);
        }
    }
}
