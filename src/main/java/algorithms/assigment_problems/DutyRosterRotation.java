package algorithms.assigment_problems;

import java.util.Arrays;

public class DutyRosterRotation {

    // Complexity: O(n) time, O(n) space for the output array. Rotating one
    // place at a time, k times, costs O(n * k) — far too slow when k can be
    // up to 10^9. Reducing k with k % n first removes every full lap around
    // the roster, so only the remaining partial rotation needs to be
    // applied, in a single O(n) pass.

    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateRoster(new String[]{"A", "B", "C", "D", "E"}, 2)));
        System.out.println(Arrays.toString(rotateRoster(new String[]{"A", "B", "C", "D", "E"}, 7)));
    }
}
