class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] s = text.split(" ");
        int c = 0;

        for(int i = 0; i < s.length;i++){
            boolean canType = true;
            for(int j = 0; j < brokenLetters.length(); j++){
                if(s[i].indexOf(brokenLetters.charAt(j)) != -1) {
                    canType = false;
                    break;
                }
            }
            if(canType) c++;
        }

        return c;
    }
}