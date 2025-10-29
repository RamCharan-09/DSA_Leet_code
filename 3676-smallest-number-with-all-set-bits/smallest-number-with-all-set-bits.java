class Solution {
    public int smallestNumber(int n) {
        String a=Integer.toBinaryString(n);
        int len=a.length();
        int power= (int)Math.pow(2,len);
        return power-1;
    }
}