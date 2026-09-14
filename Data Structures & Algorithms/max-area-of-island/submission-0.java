class Solution {
    public int dfs(int r, int c, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;

        int left = dfs(r, c - 1, grid);
        int right = dfs(r, c + 1, grid);
        int up = dfs(r + 1, c, grid);
        int down = dfs(r - 1, c, grid);

        return 1 + left + right + up + down;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(r, c, grid));
                }
            }
        }
        return maxArea;
    }
}
