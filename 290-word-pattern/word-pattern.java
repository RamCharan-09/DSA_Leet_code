class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (arr.length != pattern.length()) return false;

        HashMap<String, Character> mp = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){
            if(mp.containsKey(arr[i])){
                if(!mp.get(arr[i]).equals(pattern.charAt(i))) return false;
            }
            else{
                if(mp.containsValue(pattern.charAt(i))) return false;
                mp.put(arr[i], pattern.charAt(i));
            }
        }

        return true;
    }
}
