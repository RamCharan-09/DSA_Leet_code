class Solution {
    public int secondHighest(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                list.add(Character.getNumericValue(s.charAt(i)));
            }
        }
        int lar = -1;
        int secLar = -1;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > lar){
                secLar = lar;
                lar = list.get(i);
            }else if(list.get(i) > secLar && list.get(i) != lar){
                secLar = list.get(i);
            }
        }
        return secLar;
    }
}