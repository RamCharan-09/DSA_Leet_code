class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int tot = numBottles;
        int bottle = numBottles;

        while(bottle >= numExchange){
            bottle -= numExchange;
            numExchange++;
            tot++;
            bottle++;
        }
        return tot;
    }
}