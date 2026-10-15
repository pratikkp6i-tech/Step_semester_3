package algorithms.practice_problems;

public class VowelConsonantCounter {

    static void countVowelsConsonants(String word) {
        int vowels = 0, consonants = 0;
        String lower = word.toLowerCase();

        for (char c : lower.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) vowels++;
            else consonants++;
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    public static void main(String[] args) {
        countVowelsConsonants("Programming");
    }
}
