class Solution {
    int solve(int i, int j, int[][] grid, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if(i >= m || j >= n) {
            return Integer.MAX_VALUE / 2;
        }

        if(i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int down = grid[i][j] + solve(i + 1, j, grid, dp);
        int right = grid[i][j] + solve(i, j + 1, grid, dp);

        return dp[i][j] = Math.min(down, right);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, grid, dp);
    }
}