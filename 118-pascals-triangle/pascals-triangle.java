class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if(i > 0){
                List<Integer> prevRow = res.get(i-1);
                for(int j = 1; j < i; j++){
                    list.add(prevRow.get(j-1) + prevRow.get(j));
                }
                list.add(1);
            }
            res.add(list);
        }
        return res;
    }
}