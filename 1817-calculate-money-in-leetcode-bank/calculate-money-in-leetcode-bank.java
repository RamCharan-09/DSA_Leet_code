class Solution {
    public int totalMoney(int n) {
        int res = 0;
        int m = n/7;
        int o = n % 7;
        int st = 1;
        for(int i = 1; i <= m; i++){
            for(int j = st; j < st + 7; j++){
                res += j;
            }
            st++;
        }

        for(int i = st; i < st + o; i++){
            res += i;
        }
        return res;
    }
}