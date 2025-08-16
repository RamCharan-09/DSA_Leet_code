class Solution {
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public int findDuplicate(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i < n){
            int cor = nums[i]-1;
            if(nums[i] != nums[cor]){
                swap(nums, i, cor);
            }else{
                i++;
            }
        }
        int res = 0;
        for(int j = 0; j < n; j++){
            if(nums[j] != j+1) res = nums[j];
        }
        return res;
    }
}