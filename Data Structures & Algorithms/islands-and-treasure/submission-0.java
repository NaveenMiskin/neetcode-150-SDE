class Solution {
    class Pair {
        int row, col;
        public Pair(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0) return;

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    q.add(new Pair(i, j));
                }
            }
        }

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int row = cur.row;
            int col = cur.col;

            for(int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && 
                    grid[nrow][ncol] == Integer.MAX_VALUE) {
                        grid[nrow][ncol] = 1 + grid[row][col];
                        q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
}
