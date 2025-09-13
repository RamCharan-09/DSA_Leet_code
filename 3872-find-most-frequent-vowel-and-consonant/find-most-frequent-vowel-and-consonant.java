class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();

        Set<Character> set1 = Set.of('a', 'e', 'i', 'o', 'u');

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(set1.contains(ch)){
                mp1.put(ch, mp1.getOrDefault(ch,0)+1);
            }else{
                mp2.put(ch, mp2.getOrDefault(ch,0)+1);
            }
        }
        int a = 0;
        int b = 0;

        for (int freq : mp1.values()) {
            a = Math.max(a, freq);
        }

        for (int freq : mp2.values()) {
            b = Math.max(b, freq);
        }

        return a + b;
    }
}