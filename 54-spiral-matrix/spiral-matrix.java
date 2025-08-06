class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = m-1;
        int top = 0;
        int bottom = n-1;

        List<Integer> res = new ArrayList<>();
        while(top <= bottom && left <= right){
            // left ->right
            for(int i = left; i <= right; i++){
                res.add(matrix[top][i]);
            }
            top++;

            // top ->down
            for(int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;

            // right -> left
            if(top <= bottom){
                for(int i = right; i >= left; i--){
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }

            //down -> up
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}