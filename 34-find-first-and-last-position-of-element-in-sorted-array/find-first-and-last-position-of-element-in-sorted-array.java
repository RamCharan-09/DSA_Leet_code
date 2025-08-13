class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] ans = {-1, -1};
        ans[0] = search(nums, target, true);
        if(ans[0] != -1){
            ans[1] = search(nums, target, false);
        }
        

        return ans;
    }

    // This function just return the index of the target 

    static int search(int[] nums, int target, boolean startIndex){
        int ans = -1;
        int st = 0;
        int end = nums.length-1;

        while(st <= end){
            int mid = st + (end-st)/2;
            if(target < nums[mid]){
                end = mid-1;
            }
            else if(target > nums[mid]){
                st = mid+1;
            }
            else {
                ans = mid;
                if(startIndex){
                    end = mid -1;
                }else{
                    st = mid+1;
                }
            }
        }
        return ans;
    }
}