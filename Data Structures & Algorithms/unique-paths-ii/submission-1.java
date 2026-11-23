class Solution {
    int solve(int r, int c, int[][] grid, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if(r >= m || c >= n || grid[r][c] == 1) {
            return 0;
        }

        if(r == m - 1 && c == n - 1) {
            return 1;
        }

        if(dp[r][c] != -1) {
            return dp[r][c];
        }

        int right = solve(r, c + 1, grid, dp);
        int down = solve(r + 1, c, grid, dp);

        return dp[r][c] = right + down;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, obstacleGrid, dp);
    }
}