class Solution {
    public boolean solve(int i, int target, int[] nums, Boolean[][] dp) {
        if(target == 0) return true;
        if(i == 0) return nums[0] == target;

        if(dp[i][target] != null) return dp[i][target];

        boolean nottake = solve(i - 1, target, nums, dp);
        boolean take = false;
        if(target >= nums[i]) {
            take = solve(i - 1, target - nums[i], nums, dp);
        }
        return dp[i][target] = (take || nottake);
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int total = 0;
        for(int num : nums) total += num;

        if(total % 2 != 0) return false;

        int target = total / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for(int i = 1; i <= n; i++) {
            for(int tar = 1; tar <= target; tar++) {
                boolean nottake = dp[i - 1][tar];
                boolean take = false;
                if(tar >= nums[i - 1]) {
                    take = dp[i - 1][tar - nums[i - 1]];
                }
                dp[i][tar] = (take || nottake);
            }
        }
        return dp[n][target];
    }
}
