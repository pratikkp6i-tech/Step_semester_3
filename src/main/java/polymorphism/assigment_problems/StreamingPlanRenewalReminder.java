package polymorphism.assigment_problems;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {

    static abstract class Plan {
        abstract int validityDays();
    }

    static class Basic extends Plan {
        @Override int validityDays() { return 30; }
    }

    static class Standard extends Plan {
        @Override int validityDays() { return 90; }
    }

    static class Premium extends Plan {
        @Override int validityDays() { return 365; }
    }

    static Map<String, Plan> planTypes = new HashMap<>();
    static {
        planTypes.put("BASIC", new Basic());
        planTypes.put("STANDARD", new Standard());
        planTypes.put("PREMIUM", new Premium());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2]);

            Plan plan = planTypes.get(type);
            LocalDate renewalDate = startDate.plusDays(plan.validityDays());

            System.out.println(name + ": " + renewalDate);
        }
    }
}
