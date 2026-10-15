package algorithms.practice_problems;

public class LeapYearDetector {

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        System.out.println(isLeapYear(2024) ? "Leap year" : "Not a leap year");
        System.out.println(isLeapYear(1900) ? "Leap year" : "Not a leap year");
        System.out.println(isLeapYear(2000) ? "Leap year" : "Not a leap year");
    }
}
