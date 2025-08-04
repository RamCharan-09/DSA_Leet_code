class Solution {
    public boolean check(int[] nums) {
        int c = 0;
        for(int i = 0; i < nums.length; i++){
            int next = nums[(i+1)%nums.length];
            if(nums[i]>next){
                c++;
                if(c > 1) return false;
            }
        }
        return true;
    }
}