class Solution {
    public void solve(int idx, int[] nums, int target, List<Integer> ds, List<List<Integer>> result) {
        if(idx == nums.length) {
            if(target == 0) {
                result.add(new ArrayList<>(ds));
            }
            return;
        }
        if(nums[idx] <= target) {
            ds.add(nums[idx]);
            solve(idx, nums, target - nums[idx], ds, result);
            ds.remove(ds.size() - 1);
        }
        
        solve(idx + 1, nums, target, ds, result);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(0, nums, target, new ArrayList<>(), result);
        return result;
    }
}
