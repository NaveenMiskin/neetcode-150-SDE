class Solution {
    public void transpose(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = i + 1; j < mat[0].length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
    public void reverse(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            int l = 0;
            int r = mat[0].length - 1;
            while(l < r) {
                int temp = mat[i][l];
                mat[i][l] = mat[i][r];
                mat[i][r] = temp;
                l++;
                r--;
            }
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
}
