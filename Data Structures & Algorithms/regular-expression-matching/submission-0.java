class Solution {
    public boolean solve(int i, int j, String s, String p) {
        if (i < 0 && j < 0) return true;
        
        if (i >= 0 && j < 0) return false;
        
        if (i < 0 && j >= 0) {
            if (p.charAt(j) == '*') {
                return solve(i, j - 2, s, p);
            }
            return false;
        }
        
        if (p.charAt(j) == '*') {
            boolean skip = solve(i, j - 2, s, p);
            boolean take = false;
            if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                take = solve(i - 1, j, s, p);
            }
            
            return skip || take;
        }
        
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            return solve(i - 1, j - 1, s, p);
        }
        
        return false;
    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        return solve(m - 1, n - 1, s, p);
    }
}