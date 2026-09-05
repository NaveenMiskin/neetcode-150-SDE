class Solution {
    public boolean dfs(int r, int c, int i, String s, char[][] board) {
        int m = board.length;
        int n = board[0].length;

        if(i == s.length()) return true;

        if(r < 0 || r >= m || c < 0 || c >= n || board[r][c] != s.charAt(i)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        for(int dir = 0; dir < 4; dir++) {
            int nrow = r + drow[dir];
            int ncol = c + dcol[dir];

            if(dfs(nrow, ncol, i + 1, s, board)) {
                return true;
            }
        }
        board[r][c] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(i, j, 0, word, board)) {
                    return true;
                }
            }
        }
        return false;
    }
}
