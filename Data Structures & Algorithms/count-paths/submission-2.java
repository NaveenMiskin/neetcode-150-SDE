class Solution {
    public int paths(int i, int j, int[][] dp) {
        // Base conditions..........
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int left = paths(i, j - 1, dp);
        int up = paths(i - 1, j, dp);

        return dp[i][j] = up + left;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = (i > 0) ? dp[i-1][j] : 0;
                    int left = (j > 0) ? dp[i][j-1] : 0;

                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}
