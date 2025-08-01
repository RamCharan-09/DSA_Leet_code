class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        for(int i = 0; i < nums.length;i++){
            ones ^= (nums[i] & ~twos);
            twos ^= (nums[i] & ~ones);
        }
        return ones;
    }
}