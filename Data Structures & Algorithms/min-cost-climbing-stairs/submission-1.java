class Solution {
    public int solve(int idx, int[] arr, int[] dp) {
        if(idx >= arr.length) {
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];
        int currentcost = arr[idx] + Math.min(solve(idx + 1, arr, dp), solve(idx + 2, arr, dp));
        return dp[idx] = currentcost;
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int stFrm_0 = solve(0, cost, dp);
        int stFrm_1 = solve(1, cost, dp);
        return Math.min(stFrm_0, stFrm_1);
    }
}
