class Solution {
    public int arrangeCoins(int n) {
        long st = 0;
        long end = n;
        int ans = 0;
        while (st <= end) {
            long mid = st + (end - st) / 2;
            long sum = mid * (mid + 1) / 2;

            if(sum == n){
                return (int) mid;
            }else if(sum < n){
                ans = (int) mid;
                st = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
}