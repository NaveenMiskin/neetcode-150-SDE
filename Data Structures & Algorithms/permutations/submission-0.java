class Solution {
    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void solve(int idx, int[] nums, List<List<Integer>> result) {
        if(idx == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for(int num : nums) {
                ds.add(num);
            }
            result.add(new ArrayList<>(ds));
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            swap(i, idx, nums);
            solve(idx + 1, nums, result);
            swap(i, idx, nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutaions = new ArrayList<>();
        solve(0, nums, permutaions);
        return permutaions;
    }
}
