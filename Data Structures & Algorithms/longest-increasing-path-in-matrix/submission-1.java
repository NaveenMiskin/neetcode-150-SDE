class Solution {
    private int dfs(int row, int col, int[][] mat, int[][] dp) {

        if(dp[row][col] != 0) return dp[row][col];

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int m = mat.length;
        int n = mat[0].length;

        int best = 1;
        for(int i = 0; i < 4; i++) {
            int nrow = row + dr[i];
            int ncol = col + dc[i];

            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && 
                                mat[nrow][ncol] > mat[row][col]) {
                                    best = Math.max(best, 1 + dfs(nrow, ncol, mat, dp));
            }
        }
        return dp[row][col] = best;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int ans = 0;
        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n ; j++) {
                ans = Math.max(ans, dfs(i, j, matrix, dp));
            }
        }
        return ans;
    }
}
