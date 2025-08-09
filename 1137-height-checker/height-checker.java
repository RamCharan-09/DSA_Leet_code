class Solution {
    public int heightChecker(int[] heights) {
        
        int c = 0;
        int n = heights.length;
        int[] sortHeig = new int[n];
        for(int i = 0; i < n; i++){
            sortHeig[i] = heights[i];
        }
        Arrays.sort(sortHeig);
        for(int i = 0; i < n; i++){
            if(sortHeig[i] != heights[i]) c++;
        }
        return c;
    }
}