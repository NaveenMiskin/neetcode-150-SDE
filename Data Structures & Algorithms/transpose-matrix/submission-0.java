class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] transpose = new int[n][m];
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }
}