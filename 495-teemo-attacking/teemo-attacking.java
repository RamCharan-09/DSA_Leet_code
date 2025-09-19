class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int c = 0;
        for(int i = 0; i < timeSeries.length-1; i++){
            
            c += Math.min(duration, timeSeries[i+1] - timeSeries[i]);
            
        }
        c+= duration;
        return c;
    }
}