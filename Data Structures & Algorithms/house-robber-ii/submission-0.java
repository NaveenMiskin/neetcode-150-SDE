class Solution {
    public int solve(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return 0;
        if(n == 1) return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
            int take = nums[i] + prev2;
            int nottake = prev1;

            int curr = Math.max(take, nottake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        for(int i = 0; i < n; i++) {
            if(i != 0) temp1[i] = nums[i];
            if(i != n - 1) temp2[i] = nums[i];
        }
        return Math.max(solve(temp1), solve(temp2));
    }
}