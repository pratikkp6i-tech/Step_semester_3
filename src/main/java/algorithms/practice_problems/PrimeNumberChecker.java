package algorithms.practice_problems;

public class PrimeNumberChecker {

    static void checkPrime(int number) {
        boolean isPrime = (number > 1);
        for (int i = 2; i * i <= number && isPrime; i++) {
            if (number % i == 0) isPrime = false;
        }
        System.out.println(number + " is " + (isPrime ? "prime" : "not prime"));
    }

    public static void main(String[] args) {
        checkPrime(29);
        checkPrime(21);
    }
}
