package algorithms.assigment_problems;

public class ExamScoreBandCounter {

    // Complexity: a linear scan is O(n) time, O(1) space. This binary-search
    // solution is O(log n) time, O(1) extra space — two independent binary
    // searches find where the band starts and where it ends.

    static int countInBand(int[] scores, int low, int high) {
        int firstGE = lowerBound(scores, low);
        int firstGT = upperBound(scores, high);
        return firstGT - firstGE;
    }

    // first index where scores[index] >= target
    private static int lowerBound(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // first index where scores[index] > target
    private static int upperBound(int[] scores, int target) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}
