package abstraction.practice_problems;

import java.util.Scanner;

public class WeeklyStaffPay {

    static abstract class Staff {
        String name;

        Staff(String name) { this.name = name; }

        abstract double pay();
    }

    static class FullTime extends Staff {
        double weeklySalary;

        FullTime(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        @Override double pay() { return weeklySalary; }
    }

    static class Hourly extends Staff {
        double hours, rate;

        Hourly(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override double pay() {
            if (hours <= 40) return hours * rate;
            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }

    static class Intern extends Staff {
        double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override double pay() { return stipend; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];

            Staff staff;
            if (type.equals("FULLTIME")) {
                staff = new FullTime(parts[1], Double.parseDouble(parts[2]));
            } else if (type.equals("HOURLY")) {
                staff = new Hourly(parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
            } else {
                staff = new Intern(parts[1], Double.parseDouble(parts[2]));
            }

            double pay = staff.pay();
            total += pay;

            System.out.printf("%s: %.2f%n", staff.name, pay);
        }
        System.out.printf("Total Payroll: %.2f%n", total);
    }
}
