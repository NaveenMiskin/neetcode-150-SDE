class Solution {
    public int solve(int i, int buy, int[] arr, int[][] dp) {
        if(i >= arr.length) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 1) {
            return dp[i][buy] = Math.max(
                -arr[i] + solve(i + 1, 0, arr, dp), 0 + solve(i + 1, 1, arr, dp));
        }
        return dp[i][buy] = Math.max(
            arr[i] + solve(i + 2, 1, arr, dp), 0 + solve(i + 1, 0, arr, dp));
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 2][2];
        
        for(int i = n - 1; i >= 0; i--) {
            for(int buy = 0; buy <= 1; buy++) {
                if(buy == 1) {
                    dp[i][buy] = Math.max(
                        -prices[i] + dp[i + 1][0], 0 + dp[i + 1][1]);
                } else {
                    dp[i][buy] = Math.max(
                        prices[i] + dp[i + 2][1], 0 + dp[i + 1][0]);
                }
            }
        }
        return dp[0][1];
    }
}
