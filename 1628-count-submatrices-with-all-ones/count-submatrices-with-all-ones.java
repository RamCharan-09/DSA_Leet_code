class Solution {
    public int numSubmat(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int count = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1 && i > 0) {
                    mat[i][j] += mat[i - 1][j];
                }
                
                int width = mat[i][j];
                for (int k = j; k >= 0 && mat[i][k] > 0; k--) {
                    width = Math.min(width, mat[i][k]);
                    count += width;
                }
            }
        }
        
        return count;
    }
}