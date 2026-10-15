package algorithms.practice_problems;

public class WordReverserPalindromeChecker {

    static void reverseAndCheckPalindrome(String word) {
        StringBuilder reversed = new StringBuilder(word);
        reversed.reverse();
        String reversedWord = reversed.toString();

        boolean isPalindrome = word.equals(reversedWord);
        String display = isPalindrome ? word : reversedWord;
        String verdict = isPalindrome ? "palindrome" : "not a palindrome";

        System.out.println(display + " - " + verdict);
    }

    public static void main(String[] args) {
        reverseAndCheckPalindrome("level");
        reverseAndCheckPalindrome("java");
    }
}
