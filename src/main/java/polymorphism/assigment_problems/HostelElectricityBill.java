package polymorphism.assigment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HostelElectricityBill {

    static abstract class Room {
        abstract double bill(int units, Integer occupants);
    }

    static class SingleRoom extends Room {
        @Override double bill(int units, Integer occupants) { return units * 8.0; }
    }

    static class SharedRoom extends Room {
        @Override double bill(int units, Integer occupants) { return (units * 6.0) / occupants; }
    }

    static class ACRoom extends Room {
        @Override double bill(int units, Integer occupants) { return units * 10.0 + 200.0; }
    }

    static Map<String, Room> roomTypes = new HashMap<>();
    static {
        roomTypes.put("SINGLE", new SingleRoom());
        roomTypes.put("SHARED", new SharedRoom());
        roomTypes.put("AC", new ACRoom());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);
            Integer occupants = (parts.length > 2) ? Integer.parseInt(parts[2]) : null;

            Room room = roomTypes.get(type);
            double bill = room.bill(units, occupants);
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
