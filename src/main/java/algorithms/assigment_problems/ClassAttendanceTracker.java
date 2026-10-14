package algorithms.assigment_problems;

public class ClassAttendanceTracker {

    // Complexity: O(n) time, O(1) space. Both the present count and the
    // longest streak are found together in a single pass.

    static String attendanceSummary(int[] days) {
        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak);
            } else {
                currentStreak = 0;
            }
        }
        return "Present: " + present + ", Longest streak: " + longestStreak;
    }

    public static void main(String[] args) {
        System.out.println(attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1}));
        System.out.println(attendanceSummary(new int[]{0, 0, 0}));
    }
}
