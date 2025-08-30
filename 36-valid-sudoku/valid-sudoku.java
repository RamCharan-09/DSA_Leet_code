class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check columns
        for (int col = 0; col < 9; col++) {
            boolean[] seen = new boolean[10];
            for (int row = 0; row < 9; row++) {
                char c = board[row][col];
                if (c == '.') continue;
                int num = c - '0';
                if (seen[num]) return false;
                seen[num] = true;
            }
        }

        // Check rows
        for (int row = 0; row < 9; row++) {
            boolean[] seen = new boolean[10];
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if (c == '.') continue;
                int num = c - '0';
                if (seen[num]) return false;
                seen[num] = true;
            }
        }

        // Check 3x3 sub-boxes
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                boolean[] seen = new boolean[10];
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        char ch = board[boxRow + r][boxCol + c];
                        if (ch == '.') continue;
                        int num = ch - '0';
                        if (seen[num]) return false;
                        seen[num] = true;
                    }
                }
            }
        }

        return true;
    }
}
