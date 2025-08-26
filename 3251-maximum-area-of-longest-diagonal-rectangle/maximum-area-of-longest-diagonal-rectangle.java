class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int res = 0;
        double max = 0;
        for(int i = 0;i < dimensions.length; i++){
            int length = dimensions[i][0];
            int width = dimensions[i][1];
            double ans = Math.sqrt(length*length + width*width);
            
            if(ans > max || (ans == max && length * width > res)){
                max = ans;
                res = length * width;
            }
            
        }
        return res;
    }
}