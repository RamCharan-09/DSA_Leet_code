class Solution {
    public boolean checkIfPangram(String sentence) {
        int n = sentence.length();
        if(n < 26) return false;
        boolean[] seen = new boolean[26];
        int count = 0;

        for (int i = 0; i < n; i++) {
            char ch = sentence.charAt(i);
            int idx = ch - 'a';
            if (!seen[idx]) {
                seen[idx] = true;
                count++;
                if (count == 26) return true;
            }
        }
        return false;
    }
}