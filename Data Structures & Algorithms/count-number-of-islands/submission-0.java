class Pair {
    int row, col;
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(int r, int c, boolean[][] vis, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        vis[r][c] = true;
        q.offer(new Pair(r, c));

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();

            for(int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n 
                    && !vis[nrow][ncol] && grid[nrow][ncol] == '1') {
                        vis[nrow][ncol] = true;
                        q.offer(new Pair(nrow, ncol));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int count = 0;
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(!vis[row][col] && grid[row][col] == '1') {
                    count++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return count;
    }
}
