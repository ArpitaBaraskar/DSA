class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        if(prices[0] >= money) return money;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] + prices[i+1] <= money) {
                return money - (prices[i] + prices[i+1]);
            }else{
                return money;
            }
        }
        return money;
    }
}