class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length() > 2){
            s = helper(s);
        }

        return (s.charAt(0) == s.charAt(1));

    }

    static String helper(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i++){
        int a = s.charAt(i) - '0';
        int b = s.charAt(i - 1) - '0';
        int ans = (a+b)%10;
        sb.append(ans);
       }
       return sb.toString();
    }
}