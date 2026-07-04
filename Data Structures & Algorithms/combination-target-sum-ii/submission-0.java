class Solution {
    public void solve(
        int idx, int[] nums, int target, List<Integer> ds, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            if(i > idx && nums[i] == nums[i - 1]) continue;
            if(nums[i] > target) break;
            ds.add(nums[i]);
            solve(i + 1, nums, target - nums[i], ds, result);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        solve(0, candidates, target, new ArrayList<>(), result);
        return result;
    }
}
