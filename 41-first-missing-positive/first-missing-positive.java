class Solution {
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        // List<Integer> res = new ArrayList<>();
        int n = nums.length;
        while(i < n){
            int cor = nums[i] - 1;

            if(nums[i] > 0 && nums[i] <= n && nums[i] != nums[cor]){
                swap(nums, i, cor);
            }else{
                i++;
            }
        }

        
        for(int j = 0; j < n; j++){
            if(nums[j] != j+1){
                return j+1;
            }
        }
        return n+1;
    }
}