class Solution {
    public String sortVowels(String s) {
        List<Character> l = new ArrayList<>();
        HashSet<Character> vowels = new HashSet<>();
        // Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for(int i = 0; i < s.length(); i++){
            char ch = Character.toLowerCase(s.charAt(i));
            if(vowels.contains(ch)){
                l.add(s.charAt(i));
            }
        }
        Collections.sort(l);
        int j = 0;
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < s.length(); i++){
            if(!vowels.contains(Character.toLowerCase(s.charAt(i)))){
                sb.append(s.charAt(i));
            }else{
                sb.append(l.get(j));
                j++;
            }
        }
        return sb.toString();
    }
}