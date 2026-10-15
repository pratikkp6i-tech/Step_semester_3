package algorithms.practice_problems;

public class DigitSumAndReversal {

    static void digitSumAndReverse(int number) {
        int sum = 0;
        int reversed = 0;
        int n = number;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            reversed = reversed * 10 + digit;
            n /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reversed);
    }

    public static void main(String[] args) {
        digitSumAndReverse(4721);
    }
}
