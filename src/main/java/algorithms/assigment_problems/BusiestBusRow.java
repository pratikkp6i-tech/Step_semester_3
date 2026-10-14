package algorithms.assigment_problems;

public class BusiestBusRow {

    // Complexity: O(r * c) time to sum every row once, O(1) additional
    // space beyond the input grid.

    static String busiestRow(int[][] grid) {
        int bestRow = 0;
        int bestTotal = sumRow(grid[0]);

        for (int i = 1; i < grid.length; i++) {
            int total = sumRow(grid[i]);
            if (total > bestTotal) {
                bestTotal = total;
                bestRow = i;
            }
        }
        return "Row " + bestRow + ", Total " + bestTotal;
    }

    private static int sumRow(int[] row) {
        int sum = 0;
        for (int value : row) sum += value;
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 0, 1},
                {3, 3, 1},
                {1, 1, 1}
        };
        System.out.println(busiestRow(grid));
    }
}
