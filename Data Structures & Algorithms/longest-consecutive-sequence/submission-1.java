class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 1;
        int cnt = 0;
        int lastSmallest = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] - 1 == lastSmallest) {
                cnt++;
                lastSmallest = nums[i];
            }
            else if(nums[i] != lastSmallest) {
                cnt = 1;
                lastSmallest = nums[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
}
