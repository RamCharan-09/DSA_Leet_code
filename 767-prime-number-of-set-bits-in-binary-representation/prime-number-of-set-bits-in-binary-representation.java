class Solution {
    static boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i = 2; i*i <= n; i++){
            if(n%i == 0) return false;
        }
        return true;
    
    }
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for(int i = left; i <= right; i++){
            int n = i;
            int c = 0;
            while(n > 0){
                int bit = n%2;
                if(bit == 1)c++;
                n /= 2;
            }
            if(isPrime(c)) res++;
        }
        return res;
    }
}