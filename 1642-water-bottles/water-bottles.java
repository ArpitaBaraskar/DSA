class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles/numExchange;
        int rem = numBottles -(total*numExchange);
        int tot = total+rem , n = 0;
        while(tot >= numExchange){
            int newBottles = tot / numExchange;
            n += newBottles;
            tot = (tot % numExchange) + newBottles;
        }

        return numBottles+total+n;
    }
}