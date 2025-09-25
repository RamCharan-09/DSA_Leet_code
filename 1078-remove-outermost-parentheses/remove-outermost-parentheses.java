class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int open  = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' && open++ > 0){
                sb.append(s.charAt(i));
                
            } 
            if(s.charAt(i) == ')' && open-- > 1){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}