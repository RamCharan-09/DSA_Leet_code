class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        ArrayList<Integer> l = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    l.add(nums[i]);
                }
            }
        }
        // return l.toArray();

        int[] result = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            result[i] = l.get(i);
        }
        return result;
    }
}