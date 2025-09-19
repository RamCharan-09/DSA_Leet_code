class Solution {
    public int countSegments(String s) {
        s = s.trim().replaceAll("\\s+", " ");
        if(s.equals("") || s == null) return 0;
        
        String[] st = s.split(" ");
        return st.length;
    }
}