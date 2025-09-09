class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            if( i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){

                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    // 1 2 3 4
                    // i j   k
                    j++;
                    while(nums[j] == nums[j-1] && j < k){
                        j++;
                    }
                    
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return res;
    }
}