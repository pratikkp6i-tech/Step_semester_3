package algorithms.practice_problems;

public class StudentGradeAssignment {

    static String assignGrade(int marks) {
        if (marks >= 90) return "Grade A";
        else if (marks >= 75) return "Grade B";
        else if (marks >= 60) return "Grade C";
        else if (marks >= 40) return "Grade D";
        else return "Grade F";
    }

    public static void main(String[] args) {
        System.out.println(assignGrade(72));
        System.out.println(assignGrade(95));
        System.out.println(assignGrade(35));
    }
}
