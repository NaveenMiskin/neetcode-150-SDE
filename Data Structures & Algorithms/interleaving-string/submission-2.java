class Solution {
    public boolean solve(int i, int j, String s1, String s2, String s3, Boolean[][] dp) {
        if(s1.length() + s2.length() != s3.length()) return false;

        if(i == s1.length() && j == s2.length()) return true;

        if(dp[i][j] != null) return dp[i][j];

        int k = i + j;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            if(solve(i + 1, j, s1, s2, s3, dp)) return true;
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            if(solve(i, j + 1, s1, s2, s3, dp)) return true;
        }

        return dp[i][j] = false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();

        if(n + m != s3.length()) return false;
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        return solve(0, 0, s1, s2, s3, dp);
    }
}
