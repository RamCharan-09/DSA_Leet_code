class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int num : nums) {
            int mod = ((num % value) + value) % value;
            freq.put(mod, freq.getOrDefault(mod, 0) + 1);
        }

        int ans = 0;
        while (true) {
            int mod = ans % value;
            if (!freq.containsKey(mod) || freq.get(mod) == 0) {
                return ans;
            }
            freq.put(mod, freq.get(mod) - 1);
            ans++;
        }
    }
}