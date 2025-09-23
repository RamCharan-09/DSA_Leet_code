class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101]; 
        int max = 0;
        for (int num : nums) {
            arr[num]++;
            max = Math.max(max, arr[num]);
        }

        int res = 0;
        for (int count : arr) {
            if (count == max) {
                res+=max; 
            }
        }
        return res; 
    }
}
