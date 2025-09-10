class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        // we must know how many users need to learn new languages
        HashSet<Integer> badUsers = new HashSet<>();
        for (int[] friendship : friendships) {
            int u = friendship[0];
            int v = friendship[1];
            if (!ableToCommunicate(u, v, languages)) {
                badUsers.add(u);
                badUsers.add(v);
            }
        }

        // find the most popular languages among bad users
        HashMap<Integer, Integer> languageMap = new HashMap<>();
        int maxKnownLanguage = 0;
        for (int user : badUsers) {
            int[] language = languages[user - 1];
            for (int lang : language) {
                int freq = languageMap.getOrDefault(lang, 0) + 1;
                languageMap.put(lang, freq);
                if (freq > maxKnownLanguage) {
                    maxKnownLanguage = freq;
                }
            }
        }

        // we teach all bad users the most popular language as mentioned above
        return badUsers.size() - maxKnownLanguage;
    }

    public boolean ableToCommunicate(int u, int v, int[][] languages) {
        int[] uLanguage = languages[u - 1];
        int[] vLanguage = languages[v - 1];
        HashSet<Integer> uSet = new HashSet<>();
        for (int lang : uLanguage) {
            uSet.add(lang);
        }
        for (int lang : vLanguage) {
            if (uSet.contains(lang)) {
                return true;
            }
        }
        return false;
    }
}