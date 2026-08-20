class Solution {
    public int solve(int i, int T, int[] arr, int[][] dp) {
        if(i == 0) {
            return (T % arr[i] == 0) ? 1 : 0;
        }
        if(dp[i][T] != -1) return dp[i][T];
        int not_take = solve(i - 1, T, arr, dp);
        int take = 0;
        if(T >= arr[i]) {
            take = solve(i, T - arr[i], arr, dp);
        }
        return dp[i][T] = take + not_take;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n - 1, amount, coins, dp);
    }
}
