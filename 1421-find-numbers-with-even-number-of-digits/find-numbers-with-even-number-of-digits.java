class Solution {
    public int findNumbers(int[] nums) {
        int c = 0;
        for(int i = 0; i < nums.length; i++){
            int j =0;
            int t = nums[i];
            while(t > 0){
                t = t/10;
                j++;
            }
            if(j%2 == 0) c++;
        }
        return c;
    }
}