class Solution {
    public int numberOfPairs(int[][] points) {
        // Step 1: Sort the points manually
        // Sort by x ascending, and if x is equal, by y descending
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = 0; j < points.length - i - 1; j++) {
                int x1 = points[j][0];
                int y1 = points[j][1];
                int x2 = points[j + 1][0];
                int y2 = points[j + 1][1];

                // Swap if x1 > x2 OR (x1 == x2 AND y1 < y2)
                if (x1 > x2 || (x1 == x2 && y1 < y2)) {
                    int[] temp = points[j];
                    points[j] = points[j + 1];
                    points[j + 1] = temp;
                }
            }
        }

        // Step 2: Count valid pairs
        int count = 0;
        int n = points.length;
        int INF = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int y1 = points[i][1];
            int maxY = -INF;

            for (int j = i + 1; j < n; j++) {
                int y2 = points[j][1];

                // Check if y2 is the largest seen so far and <= y1
                if (y2 > maxY && y2 <= y1) {
                    maxY = y2;
                    count++;
                }
            }
        }

        return count;
    }
}
