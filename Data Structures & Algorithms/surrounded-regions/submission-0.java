class Solution {
    class Pair {
        int row;
        int col;
        public Pair(int i, int j) {
            this.row = i;
            this.col = j;
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if(board[i][j] == 'O') {
                        q.add(new Pair(i, j));
                        board[i][j] = '#';
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int row = cur.row;
            int col = cur.col;

            int[] drow = {-1, 0, 1, 0};
            int[] dcol = {0, 1, 0, -1};

            for(int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && board[nrow][ncol] == 'O') {
                    q.add(new Pair(nrow, ncol));
                    board[nrow][ncol] = '#';
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
