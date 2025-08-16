class Solution {

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a]= arr[b];
        arr[b] = temp;
    }
    public int missingNumber(int[] nums) {
        int i = 0;
        int n =  nums.length;
        while(i < n){
            // int corr = nums[i]-1;
            int corr = nums[i];
            if(nums[i] < n && nums[i] != nums[corr]){
                swap(nums, i, corr);
            }else{
                i++;
            }
        }

        for(i = 0; i < n; i++){
            if(nums[i] != i) return i;
        }
        return n;
    }
    
}