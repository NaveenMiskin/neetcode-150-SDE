class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        int ans = nums[0];
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[n-1]) {
                l = mid + 1;
            } else {
                ans = nums[mid];
                r = mid - 1;
            }
        }
        return ans;
    }
}
