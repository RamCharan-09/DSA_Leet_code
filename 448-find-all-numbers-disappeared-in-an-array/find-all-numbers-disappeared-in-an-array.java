class Solution {
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        while(i < n){
            int cor = nums[i] - 1;
            if(nums[i] != nums[cor]){
                swap(nums, i, cor);
            }else{
                i++;
            }
        }

        for(int j = 0; j < n; j++){
            if(nums[j] != j+1) res.add(j+1);
        }
        return res;
    }
}