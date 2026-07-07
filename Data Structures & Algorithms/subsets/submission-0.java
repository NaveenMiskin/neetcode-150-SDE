class Solution {
    public void solve(int idx, int[] nums, List<Integer> ds, List<List<Integer>> result) {
        if(idx == nums.length) {
            result.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[idx]);
        solve(idx + 1, nums, ds, result);

        ds.remove(ds.size() - 1);
        solve(idx + 1, nums, ds, result);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), result);
        return result;
    }
}
