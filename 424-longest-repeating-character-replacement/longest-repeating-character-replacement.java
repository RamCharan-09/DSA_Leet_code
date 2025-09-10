class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        // HashMap<Character, Integer> = new HashMap<>();
        int max = 0, start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            count[s.charAt(end) - 'A']++;
            max = Math.max(max, count[s.charAt(end) - 'A']);

            while (end - start + 1 - max > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
        }

        return s.length() - start;
    }
}
