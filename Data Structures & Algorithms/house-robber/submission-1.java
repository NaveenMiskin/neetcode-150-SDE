class Solution {
    public int solve(int idx, int[] arr, int[] dp) {
        if(idx == 0) return arr[idx];
        if(idx < 1) return 0;
        
        if(dp[idx] != -1) return dp[idx];

        int take = arr[idx] + solve(idx - 2, arr, dp);
        int nottake = solve(idx - 1, arr, dp);
        return dp[idx] = Math.max(take, nottake);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, nums, dp);
    }
}
