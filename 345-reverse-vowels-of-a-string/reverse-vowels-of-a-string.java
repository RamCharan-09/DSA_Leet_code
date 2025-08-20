class Solution {
    public String reverseVowels(String s) {
        List<Character> l = new ArrayList<Character>();
        for(int i = 0; i < s.length();i++){
            char ch = Character.toLowerCase(s.charAt(i));
            
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                l.add(s.charAt(i));
            }
        }
        Collections.reverse(l);
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = Character.toLowerCase(s.charAt(i));
            
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){  
                sb.append(l.get(j));
                j++;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}