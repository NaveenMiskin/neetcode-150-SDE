class Solution {
    public List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i<board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public void solve(int col, char[][] board, int[] leftrow, int[] lowerdiagonal, int[] upperdiagonal, List<List<String>> result, int n) {
        if(col == n) {
            result.add(construct(board));
            return;
        }
        for(int row = 0; row < n; row++) {
            if(leftrow[row] == 0 && lowerdiagonal[row + col] == 0 && upperdiagonal[n - 1 + col - row] == 0) {

                board[row][col] = 'Q';
                leftrow[row] = 1;
                lowerdiagonal[row + col] = 1;
                upperdiagonal[n - 1 + col - row] = 1;

                solve(col + 1, board, leftrow, lowerdiagonal, upperdiagonal, result, n);

                board[row][col] = '.';
                leftrow[row] = 0;
                lowerdiagonal[row + col] = 0;
                upperdiagonal[n - 1 + col - row] = 0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for(int i=0; i<n; i++) {
            Arrays.fill(board[i], '.');
        }

        int leftRow[] = new int[n];
        int lowerDiagonal[] = new int[2 * n - 1];
        int upperDiagonal[] = new int[2 * n - 1];

        solve(0, board, leftRow, lowerDiagonal, upperDiagonal, result, n);
        return result;
    }
}
