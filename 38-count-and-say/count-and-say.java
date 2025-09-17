class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");

        for(int i = 1; i < n; i++){
            StringBuilder sb1 = new StringBuilder();
            int c = 1;
            for(int j = 1; j < sb.length(); j++){
                if(sb.charAt(j) == sb.charAt(j-1)) c++;
                else{
                    sb1.append(c);
                    sb1.append(sb.charAt(j-1));
                    c = 1;
                } 
            }
            sb1.append(c).append(sb.charAt(sb.length()-1));
            sb = sb1;
        }

        return sb.toString();
    }
}