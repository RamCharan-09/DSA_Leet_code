class Solution {
    public int largestAltitude(int[] gain) {
        int[] alt = new int[gain.length+1];
        alt[0] = 0;
        int sum = 0;
        int res = 0;
        for(int i = 1; i < alt.length; i++){
            sum += gain[i-1];
            alt[i] = sum;
            if(alt[i] > res){
                res = alt[i];
            }
        }
        return res;
    }
}