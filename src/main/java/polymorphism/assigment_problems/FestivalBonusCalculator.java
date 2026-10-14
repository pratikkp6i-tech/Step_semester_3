package polymorphism.assigment_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FestivalBonusCalculator {

    static abstract class Employee {
        abstract double bonus(double salary);
    }

    static class FullTime extends Employee {
        @Override double bonus(double salary) { return salary * 0.10; }
    }

    static class PartTime extends Employee {
        @Override double bonus(double salary) { return salary * 0.05; }
    }

    static class Intern extends Employee {
        @Override double bonus(double salary) { return 2000.0; }
    }

    static Map<String, Employee> employeeTypes = new HashMap<>();
    static {
        employeeTypes.put("FULLTIME", new FullTime());
        employeeTypes.put("PARTTIME", new PartTime());
        employeeTypes.put("INTERN", new Intern());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);

            Employee employee = employeeTypes.get(type);
            double bonus = employee.bonus(salary);
            total += bonus;

            System.out.printf("%s: %.2f%n", name, bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", total);
    }
}
