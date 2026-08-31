class Solution {
    public int solve(int i, int j, int[] nums, int[][] dp) {
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int maxi = Integer.MIN_VALUE;
        for(int ind = i; ind <= j; ind++) {
            int cost = nums[i - 1] * nums[ind] * nums[j + 1] +
                        solve(i, ind - 1, nums, dp) + solve(ind + 1, j, nums, dp);
            maxi = Math.max(maxi, cost);
        }
        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2];
        int m = arr.length;

        arr[0] = 1;
        arr[m - 1] = 1;
        for(int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        
        int[][] dp = new int[n + 2][n + 2];
        for(int i = n; i >= 1; i--) {
            for(int j = 1; j <= n; j++) {
                if(i > j) continue;
                int maxi = Integer.MIN_VALUE;
                for(int ind = i; ind <= j; ind++) {
                    int cost = arr[i - 1] * arr[ind] * arr[j + 1] +
                                dp[i][ind - 1] + dp[ind + 1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }
}
