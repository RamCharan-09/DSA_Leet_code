class Solution {
    public int splitArray(int[] nums, int k) {
        int st = 0;
        int end = nums.length-1;

        for(int i = 0; i < nums.length; i++){
            // By the end of the loop the start will contain the maximum element of the array
            st = Math.max(nums[i], st);
            end += nums[i];
        }

        // applying the binary search

        while(st < end){
            // try for the middle as the potential answer
            int mid = st + (end-st)/2;

            // calculate the number of pieces that you can divide with the max sum
            int sum = 0;
            int pieces = 1;
            for(int num : nums){
                if(sum + num > mid){
                    // you cant add the num in this subarray
                    sum = num;
                    pieces++;
                }
                else{
                    sum += num;
                }
            }
            if(pieces > k){
                st = mid+1;
            }
            else{
                end = mid;
            }
        }

        // start == end
        return st;
    }
}