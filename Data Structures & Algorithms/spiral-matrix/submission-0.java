class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;
        List<Integer> ans = new ArrayList<>();
        while(left <= right && top <= bottom) {
            // left to right traversal.........
            for(int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // top to bottom traversal.....
            for(int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // right to left traversing......
            if(top <= bottom) {
                for(int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // bottom to top traversal.....
            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}
