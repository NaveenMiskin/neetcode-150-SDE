class Solution {
    public int solve(int i, int target, int[] nums, int[][] dp) {
        if(i < 0) {
            return (target == 0) ? 1 : 0;
        }
        
        if(dp[i][target] != -1) return dp[i][target];
        int not_take = solve(i - 1, target, nums, dp);
        int take = 0;
        if(target >= nums[i]) {
            take = solve(i - 1, target - nums[i], nums, dp);
        }

        return dp[i][target] = take + not_take;
    }
    public int numberOfWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n - 1, target, nums, dp);
    }
    public int countnoOfWays(int[] nums, int target) {
        int totalsum = 0;
        for(int num : nums) totalsum += num;
        if(totalsum - target < 0 || (totalsum - target) % 2 == 1) return 0;
        return numberOfWays(nums, (totalsum - target) / 2);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return countnoOfWays(nums, target);
    }
}
