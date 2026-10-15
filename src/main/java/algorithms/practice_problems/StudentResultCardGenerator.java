package algorithms.practice_problems;

public class StudentResultCardGenerator {

    static class Student {
        String name;
        int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double average() {
            int sum = 0;
            for (int m : marks) sum += m;
            return sum / (double) marks.length;
        }

        String grade() {
            double avg = average();
            if (avg >= 90) return "A";
            if (avg >= 75) return "B";
            if (avg >= 60) return "C";
            if (avg >= 40) return "D";
            return "F";
        }

        void printResult() {
            System.out.printf("%s: Average %.1f, Grade %s%n", name.toUpperCase(), average(), grade());
        }
    }

    public static void main(String[] args) {
        Student asha = new Student("Asha", new int[]{80, 90, 70});
        Student ravi = new Student("Ravi", new int[]{60, 55, 50});

        asha.printResult();
        ravi.printResult();
    }
}
