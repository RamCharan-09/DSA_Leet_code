class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        long target = 0;
        for (int i=0; i<=60; i++){
            target = (long)num1- (long)num2*i;

            if(target<=0)
                continue;
           long bit = Long.bitCount(target);
           if(bit<=i && i<=target){
            return i;
           } 
            
        }
        return -1;
    }
}