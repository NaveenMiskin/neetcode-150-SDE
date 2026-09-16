class Solution {
    private void dfs(int r, int c, int prevHeight, boolean[][] visited, int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        if(r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        // up
        dfs(r - 1, c, heights[r][c], visited, heights);
        //down
        dfs(r + 1, c, heights[r][c], visited, heights);
        // left
        dfs(r, c - 1, heights[r][c], visited, heights);
        // right
        dfs(r, c + 1, heights[r][c], visited, heights);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        List<List<Integer>> res = new ArrayList<>();
        if(heights == null || m == 0 || n == 0) return res;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // left  ->  right
        for(int r = 0; r < m; r++) {
            dfs(r, 0, heights[r][0], pacific, heights);
            dfs(r, n - 1, heights[r][n - 1], atlantic, heights);
        }

        // top  ->  bottom
        for(int c = 0; c < n; c++) {
            dfs(0, c, heights[0][c], pacific, heights);
            dfs(m - 1, c, heights[m - 1][c], atlantic, heights);
        }

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }
}
