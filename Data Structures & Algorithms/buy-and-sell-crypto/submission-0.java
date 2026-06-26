class Solution {
    public int maxProfit(int[] prices) {
        int buyday = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(buyday < prices[i]) {
                profit = Math.max(profit, prices[i] - buyday);
            }
            buyday = Math.min(buyday, prices[i]);
        }
        return profit;
    }
}
