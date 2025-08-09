class Solution {
    public int dominantIndex(int[] nums) {
        int res = -1;
        int sl = -1;
        int maxIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > res){
                sl = res;
                res = nums[i];
                maxIndex = i;
            }else if(res != nums[i] && nums[i] > sl) sl = nums[i];
        }
        if(res >= 2*sl){
            return maxIndex;
        }else{
            return -1;
        }
    }

}