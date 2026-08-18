class Solution {
    public int solve(int i, int target, int[] arr, int[][] dp) {
        if(i == 0) {
            if(target % arr[i] == 0) return target / arr[i];
            else return (int)1e9;
        }

        if(dp[i][target] != -1) return dp[i][target];
        int not_take = 0 + solve(i - 1, target, arr, dp);
        int take = Integer.MAX_VALUE;
        if(arr[i] <= target) {
            take = 1 + solve(i, target - arr[i], arr, dp);
        }
        return dp[i][target] = Math.min(take, not_take);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = solve(n - 1, amount, coins, dp);
        return (ans >= (int)1e9) ? -1 : ans;
    }
}
