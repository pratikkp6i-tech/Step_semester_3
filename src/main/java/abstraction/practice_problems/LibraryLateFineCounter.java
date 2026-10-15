package abstraction.practice_problems;

import java.util.Scanner;

public class LibraryLateFineCounter {

    static abstract class LibraryItem {
        String title;

        LibraryItem(String title) { this.title = title; }

        abstract double fine(int daysLate);
    }

    static class Book extends LibraryItem {
        Book(String title) { super(title); }
        @Override double fine(int daysLate) { return daysLate * 2.0; }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title) { super(title); }
        @Override double fine(int daysLate) { return Math.min(daysLate * 5.0, 50.0); }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) { super(title); }
        @Override double fine(int daysLate) { return daysLate * 1.0; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String title = parts[1];
            int daysLate = Integer.parseInt(parts[2]);

            LibraryItem item;
            if (type.equals("BOOK")) item = new Book(title);
            else if (type.equals("DVD")) item = new Dvd(title);
            else item = new Magazine(title);

            double fine = item.fine(daysLate);
            total += fine;

            System.out.printf("%s: %.2f%n", item.title, fine);
        }
        System.out.printf("Total Fines: %.2f%n", total);
    }
}
