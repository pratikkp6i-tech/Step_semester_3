package abstraction.practice_problems;

import java.util.Scanner;

public class GardenPlotAreaReport {

    static abstract class Plot {
        String owner;
        String shapeName;

        Plot(String owner, String shapeName) {
            this.owner = owner;
            this.shapeName = shapeName;
        }

        abstract double area();
    }

    static class Circle extends Plot {
        double radius;

        Circle(String owner, double radius) {
            super(owner, "CIRCLE");
            this.radius = radius;
        }

        @Override double area() { return Math.PI * radius * radius; }
    }

    static class Rectangle extends Plot {
        double length, width;

        Rectangle(String owner, double length, double width) {
            super(owner, "RECTANGLE");
            this.length = length;
            this.width = width;
        }

        @Override double area() { return length * width; }
    }

    static class Triangle extends Plot {
        double base, height;

        Triangle(String owner, double base, double height) {
            super(owner, "TRIANGLE");
            this.base = base;
            this.height = height;
        }

        @Override double area() { return 0.5 * base * height; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double totalArea = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String shape = parts[0];
            String owner = parts[1];

            Plot plot;
            if (shape.equals("CIRCLE")) {
                plot = new Circle(owner, Double.parseDouble(parts[2]));
            } else if (shape.equals("RECTANGLE")) {
                plot = new Rectangle(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
            } else {
                plot = new Triangle(owner, Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
            }

            double area = plot.area();
            totalArea += area;

            System.out.printf("%s (%s): %.2f%n", plot.owner, plot.shapeName, area);
        }
        System.out.printf("Total Area: %.2f%n", totalArea);
    }
}
