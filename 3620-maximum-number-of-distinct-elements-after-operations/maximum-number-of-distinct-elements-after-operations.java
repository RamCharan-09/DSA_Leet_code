class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        List<Integer> l = new LinkedList<>();
        Arrays.sort(nums);

        l.add(nums[0] - k);

        for(int i = 1; i < nums.length; i++){
            int n = nums[i];
            int last = l.getLast();

            if(n - k > last){
                l.add(n - k);
            }else{
                int next = last + 1;
                if(next <= n + k){
                    l.add(last + 1);
                }
            }
        }
        return l.size();
    }
}