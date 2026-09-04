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

        Boolean[][] dp = new Boolean[n][target + 1];

        return solve(n - 1, target, nums, dp);
    }
}
