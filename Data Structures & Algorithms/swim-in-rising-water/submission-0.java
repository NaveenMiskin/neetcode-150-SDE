class Solution {
    class Cell {
        int elevation, row, col;
        public Cell(int elevation, int row, int col) {
            this.elevation = elevation;
            this.row = row;
            this.col = col;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.elevation - b.elevation);

        pq.offer(new Cell(grid[0][0], 0, 0));

        boolean[][] vis = new boolean[n][n];
        int maxElevation = 0;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!pq.isEmpty()) {
            Cell cur = pq.poll();
            int elevation = cur.elevation;
            int row = cur.row;
            int col = cur.col;

            maxElevation = Math.max(maxElevation, elevation);

            if(row == n - 1 && col == n - 1) return maxElevation;

            for(int i = 0; i < 4; i++) {
                int adjRow = row + dr[i];
                int adjCol = col + dc[i];

                if(adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < n && 
                !vis[adjRow][adjCol]) {
                    vis[adjRow][adjCol] = true;
                    pq.offer(new Cell(grid[adjRow][adjCol], adjRow, adjCol));
                }
            }
        }
        return maxElevation;
    }
}
