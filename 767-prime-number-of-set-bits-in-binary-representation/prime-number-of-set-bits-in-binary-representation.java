class Solution {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> primeSet = Set.of(2, 3, 5, 7, 11, 13, 17, 19);
        int res = 0;
        for(int i = left; i <= right; i++){
            int c = Integer.bitCount(i); // counts number of 1s in binary
            if(primeSet.contains(c)) res++;
        }
        return res;
    }
}
