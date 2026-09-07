class Pair {
    int row;
    int col;
    int min;

    public Pair(int r, int c, int m) {
        this.row = r;
        this.col = c;
        this.min = m;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[m][n];

        int cntFresh = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if(grid[i][j] == 1) cntFresh++;
            }
        }

        int tm = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int count = 0;
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int r = cur.row;
            int c = cur.col;
            int min = cur.min;
            tm = Math.max(tm, min);
            for(int i = 0; i < 4; i++) {
                int nrow = r + dr[i];
                int ncol = c + dc[i];
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, min + 1));
                    vis[nrow][ncol] = 2;
                    count++;
                }
            }
        }
        if(count != cntFresh) return -1;
        return tm;
    }
}
