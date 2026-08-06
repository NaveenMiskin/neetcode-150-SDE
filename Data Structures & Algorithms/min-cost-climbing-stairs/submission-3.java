class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n <= 1) return 0;

        // int[] dp = new int[n];
        int prev2 = cost[0];
        int prev1 = cost[1]; 
        // dp[0] = cost[0];
        // dp[1] = cost[1];

        for(int i = 2; i < n; i++) {
            // dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            int cur = cost[i] + Math.min(prev2, prev1);
            prev2 = prev1;
            prev1 = cur;
        }
        return Math.min(prev1, prev2);
    }
}
