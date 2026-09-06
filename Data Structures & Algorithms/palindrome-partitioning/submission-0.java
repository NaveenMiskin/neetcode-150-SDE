class Solution {
    private boolean isPalindrome(int i, int j, String s) {
        while(i <= j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
    public void solve(int ind, String s, List<String> ds, List<List<String>> res) {
        if(ind == s.length()) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i = ind; i < s.length(); i++) {
            if(isPalindrome(ind, i, s)) {
                ds.add(s.substring(ind, i + 1));
                solve(i + 1, s, ds, res);
                ds.remove(ds.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        solve(0, s, new ArrayList<>(), res);
        return res;
    }
}
