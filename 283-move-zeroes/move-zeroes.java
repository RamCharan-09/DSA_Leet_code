class Solution {
    public void moveZeroes(int[] nums) {
        int c = 0;
        ArrayList<Integer> l = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) c++;
            else l.add(nums[i]);
        }
        for(int i = 0; i < c; i++){
            l.add(0);
        }
        for(int i = 0; i < nums.length;i++){
            nums[i] = l.get(i);
        }

    }
}