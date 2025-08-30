class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int col = 0; col < n; col++) {
            boolean[] seen = new boolean[n + 1];
            for (int row = 0; row < n; row++) {
                int val = matrix[row][col];
                if (val < 1 || val > n || seen[val]) return false;
                seen[val] = true;
            }
        }

        for (int row = 0; row < n; row++) {
            boolean[] seen = new boolean[n + 1];
            for (int col = 0; col < n; col++) {
                int val = matrix[row][col];
                if (val < 1 || val > n || seen[val]) return false;
                seen[val] = true;
            }
        }

        return true;
    }
}
