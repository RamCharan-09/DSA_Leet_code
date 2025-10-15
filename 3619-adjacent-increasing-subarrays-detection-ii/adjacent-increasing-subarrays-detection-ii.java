class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        
        int n = nums.size();
        int a = 0;
        int b = 0;
        int lastb = Integer.MIN_VALUE;
        int lasta = Integer.MIN_VALUE;

        int ans = 1;

        for(int i = 0; i < n; i++){

            if(nums.get(i) > nums.get(b)){
                b = i;
            }
            else{
                //giving new value to a;
                lastb = b;
                lasta = a;
                a = i;
                b = a;
            }
            ans = Math.max(ans, (b - a + 1)/2);
            if(lastb != Integer.MIN_VALUE || lastb + 1 == a){
                if((lastb - lasta + 1 >= (b - a + 1)))
                    ans = Math.max(ans, b - a + 1);
            }
        }
        ans = Math.max(ans, (b - a + 1)/2);
        if(lastb != Integer.MIN_VALUE || lastb + 1 == a){
            if((lastb - lasta + 1 >= (b - a + 1)))
                ans = Math.max(ans, b - a + 1);
        }
        return ans;
    }
}