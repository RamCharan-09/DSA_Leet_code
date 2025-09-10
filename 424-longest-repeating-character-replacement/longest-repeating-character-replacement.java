class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxCount = 0;
        int result = 0;
        while(j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            maxCount = Math.max(maxCount, map.get(s.charAt(j)));
            while((j - i + 1)-maxCount>k){
                map.put(s.charAt(i) , map.get(s.charAt(i)) - 1);
                i++;
            }
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }
}