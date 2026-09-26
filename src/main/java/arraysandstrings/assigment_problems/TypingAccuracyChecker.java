package arraysandstrings.assigment_problems;

public class TypingAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatch = -1;
        int total = original.length();

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (matched / (double) total) * 100;
        StringBuilder result = new StringBuilder();
        result.append("Matched: ").append(matched).append("/").append(total)
                .append(" | Accuracy: ").append(String.format("%.2f", accuracy)).append("%");

        if (firstMismatch == -1) {
            result.append(" | No Mismatches");
        } else {
            result.append(" | First Mismatch at position ").append(firstMismatch + 1)
                    .append(" ('").append(original.charAt(firstMismatch)).append("' vs '")
                    .append(typed.charAt(firstMismatch)).append("')");
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
