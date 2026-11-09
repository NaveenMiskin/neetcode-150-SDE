class Solution {
    int solve(int i, int bitwise, int[] nums) {
        if(i == nums.length) {
            return bitwise;
        }

        int take = solve(i + 1, bitwise ^ nums[i], nums);
        int nottake = solve(i + 1, bitwise, nums);

        return take + nottake;
    }
    public int subsetXORSum(int[] nums) {
        return solve(0, 0, nums);
    }
}