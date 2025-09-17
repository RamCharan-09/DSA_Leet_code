class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int idx = 0;
        while(i < chars.length){
            char curr = chars[i];
            int count = 1;
            i++;
            while(i < chars.length && curr == chars[i]){
                count++;
                i++;
            }

            chars[idx++] = curr;

            if(count > 1){
                for(char t : String.valueOf(count).toCharArray()){
                    chars[idx++] = t;
                }
            }
        }
        return idx;
    }
}