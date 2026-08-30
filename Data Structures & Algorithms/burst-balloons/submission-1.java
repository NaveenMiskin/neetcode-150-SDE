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
        
        int[][] dp = new int[n + 1][n + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(1, n, arr, dp);
    }
}
