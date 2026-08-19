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
        
        for(int tar = 0; tar <= amount; tar++) {
            if(tar % coins[0] == 0)
                dp[0][tar] = tar / coins[0];
            else
                dp[0][tar] = (int)1e9;
        }

        for(int i = 1; i < n; i++) {
            for(int tar = 0; tar <= amount; tar++) {
                int not_take = 0 + dp[i - 1][tar];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= tar) {
                    take = 1 + dp[i][tar - coins[i]];
                }
                dp[i][tar] = Math.min(take, not_take);
            }
        }
        return (dp[n - 1][amount] >= (int)1e9) ? -1 : dp[n-1][amount];
    }
}
