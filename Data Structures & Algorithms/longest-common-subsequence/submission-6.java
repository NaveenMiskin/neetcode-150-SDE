class Solution {
    int solve(int i, int j, String text1, String text2, int[][] dp) {
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)) {
            return 1 + solve(i - 1, j - 1, text1, text2, dp);
        }
        int left = 0;
        int right = 0;

        if(i >= 0) {
            left = solve(i - 1, j, text1, text2, dp);
        }
        if(j >= 0) {
            right = solve(i, j - 1, text1, text2, dp);
        }

        return dp[i][j] = Math.max(left, right);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int left = dp[i - 1][j];
                    int right = dp[i][j - 1];

                    dp[i][j] = Math.max(left, right);
                }
            }
        }

        return dp[m][n];
    }
}
