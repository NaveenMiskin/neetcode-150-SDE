class Solution {
    public int solve(int ind, int prev_ind, int[] nums, int[][] dp) {
        int n = nums.length;

        if(ind == n) return 0;

        if(dp[ind][prev_ind + 1] != -1) return dp[ind][prev_ind + 1];

        int not_take = 0 + solve(ind + 1, prev_ind, nums, dp);

        int take = Integer.MIN_VALUE;
        if(prev_ind == -1 || nums[ind] > nums[prev_ind]) {
            take = 1 + solve(ind + 1, ind, nums, dp);
        }

        return dp[ind][prev_ind + 1] = Math.max(take, not_take);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // int[][] dp = new int[n + 1][n + 1];
        
        int[] prev = new int[n + 1];
        //int[] cur = new int[n + 1];
        for(int ind = n - 1; ind >= 0; ind--) {
            for(int prev_ind = ind - 1; prev_ind >= -1; prev_ind--) {

                int not_take = 0 + prev[prev_ind + 1];

                int take = Integer.MIN_VALUE;
                if(prev_ind == -1 || nums[ind] > nums[prev_ind]) {
                    take = 1 + prev[ind + 1];
                }

                prev[prev_ind + 1] = Math.max(take, not_take);
            }
        }
        return prev[0];
    }
}
