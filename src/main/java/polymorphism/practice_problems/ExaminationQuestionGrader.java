package polymorphism.practice_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExaminationQuestionGrader {

    static final Pattern LINE_PATTERN =
            Pattern.compile("^(\\S+)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)$");

    interface Grader {
        double score(String correctAnswer, String studentAnswer, int points);
    }

    static Map<String, Grader> graders = new HashMap<>();
    static {
        graders.put("MCQ", (correct, student, points) ->
                correct.equals(student) ? points : 0.0);

        graders.put("TF", (correct, student, points) ->
                correct.equals(student) ? points : 0.0);

        graders.put("ESSAY", (correct, student, points) -> {
            String[] keywords = correct.split(",");
            int matches = 0;
            String lowerStudent = student.toLowerCase();
            for (String keyword : keywords) {
                if (lowerStudent.contains(keyword.trim().toLowerCase())) {
                    matches++;
                }
            }
            if (matches >= 2) return points * 0.75;
            if (matches == 1) return points * 0.50;
            return 0.0;
        });
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            Matcher m = LINE_PATTERN.matcher(line);
            if (!m.matches()) continue;

            String type = m.group(1);
            String correctAnswer = m.group(3);
            String studentAnswer = m.group(4);
            int points = Integer.parseInt(m.group(5));

            double score = graders.get(type).score(correctAnswer, studentAnswer, points);
            total += score;

            System.out.printf("%s: %.2f%n", type, score);
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}
