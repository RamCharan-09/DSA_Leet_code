class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do{
            slow = square(slow);
            fast = square(square(fast));
        }while(fast != slow);

        if(slow == 1){
            return true;
        }
        return false;
    }

    public int square(int n){
        int res = 0;
        while(n > 0){
            int rem = n%10;
            res += rem*rem;
            n/=10;
        }
        return res;
    }
}