package abstraction.assigment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class CollegeFeeCounter {

    interface UsesBus {
        default double transportFee() { return 12000.0; }
    }

    static abstract class Student {
        abstract double tuition();

        double totalFee() {
            double fee = tuition();
            if (this instanceof UsesBus) {
                fee += ((UsesBus) this).transportFee();
            }
            return fee;
        }
    }

    static class DayScholar extends Student implements UsesBus {
        @Override double tuition() { return 40000.0; }
    }

    static class Hosteller extends Student {
        @Override double tuition() { return 40000.0 + 60000.0; }
    }

    static class Scholar extends Student implements UsesBus {
        @Override double tuition() { return 20000.0; }
    }

    static Map<String, Supplier<Student>> studentTypes = new HashMap<>();
    static {
        studentTypes.put("DAY_SCHOLAR", DayScholar::new);
        studentTypes.put("HOSTELLER", Hosteller::new);
        studentTypes.put("SCHOLAR", Scholar::new);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];

            Student student = studentTypes.get(type).get();
            double fee = student.totalFee();
            total += fee;

            System.out.printf("%s: %.2f%n", name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", total);
    }
}
