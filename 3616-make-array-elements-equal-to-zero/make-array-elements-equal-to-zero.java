class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 1; i < n; i++)
            left[i] = left[i - 1] + nums[i - 1];

        for(int i = n - 2; i >= 0; i--)
            right[i] = right[i + 1] + nums[i + 1];

        int ans = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                int dif = Math.abs(right[i] - left[i]);
                if(dif == 1) ans++;
                else if(dif == 0) ans += 2;   
            }
        }

        return ans;
    }
}