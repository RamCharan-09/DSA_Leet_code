class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == target){
                res[0] = i;
                break;
            }
        }
        if(res[0] == -1) return res;
        for(int j = n-1; j >= res[0]; j--){
            if(nums[j] == target){
                res[1] = j;
                break;
            }
        }
        return res;
    }
}