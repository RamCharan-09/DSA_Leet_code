class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int c = 0;
        int rulKey = 0;

        if(ruleKey.equals("type")){
            rulKey = 0;
        }else if(ruleKey.equals("color")){
            rulKey = 1;
        }else{
            rulKey = 2;
        }
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).get(rulKey).equals(ruleValue)){
                c++;
            }
        }
        return c;
    }
}