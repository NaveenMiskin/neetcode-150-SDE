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
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(m - 1, n - 1, text1, text2, dp);
    }
}
