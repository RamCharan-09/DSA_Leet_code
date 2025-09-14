class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {

        Set<String> words = new HashSet<>();

        Map<String, String> mp1 = new HashMap<>();
        Map<String, String> mp2 = new HashMap<>();
        for(String word : wordlist){
            words.add(word);
            mp1.putIfAbsent(word.toLowerCase(), word);
            mp2.putIfAbsent(getVowelCase(word.toLowerCase()), word);
        }

        for(int i = 0; i < queries.length; i++){
            String wor = queries[i];
            if(words.contains(wor)) continue;

            String lower = wor.toLowerCase();
            if(mp1.containsKey(lower)){
                queries[i] = mp1.get(lower);
                continue;
            }

            String vowCase = getVowelCase(lower);

            if(mp2.containsKey(vowCase)){
                queries[i] = mp2.get(vowCase);
            }else{
                queries[i] = "";
            }
        }
        return queries;
    }
    public String getVowelCase(String str){
        char[] arr = str.toCharArray();
        for(int i=0;i<arr.length;i++)
            if(isVowel(arr[i]))
                arr[i] = '.';
        return String.valueOf(arr);
    }

    public boolean isVowel(char ch){
        return ch=='a' || ch=='e' ||
        ch == 'i' || ch == 'o' || ch == 'u';
    }

}