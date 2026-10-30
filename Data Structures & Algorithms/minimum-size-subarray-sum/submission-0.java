class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minlen = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while(sum >= target) {
                minlen = Math.min(minlen, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}