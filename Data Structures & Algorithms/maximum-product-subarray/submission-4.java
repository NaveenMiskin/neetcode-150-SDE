class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int tmax = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            int tmin = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));

            max = tmax;
            min = tmin;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
