class Solution {
    void solve(int start, int n, int k, List<Integer> ds, List<List<Integer>> ans) {
        if(ds.size() == k) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = start; i <= n; i++) {
            ds.add(i);
            solve(i + 1, n, k, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(1, n, k, new ArrayList<>(), ans);

        return ans;
    }
}