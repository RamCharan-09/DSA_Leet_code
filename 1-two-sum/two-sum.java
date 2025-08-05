class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];
        res[0] = res[1] = -1;
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i < n; i++){
            int num = nums[i];
            int need = target-num;
            if(m.containsKey(need)){
                res[0] = m.get(need);
                res[1] = i;
                return res;
            }
            m.put(nums[i], i);
        }
        return res;
    }
}