class Solution {
    public boolean bS(int[] arr, int x) {
        int l = 0;
        int r = arr.length-1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] == x) return true;
            if(arr[mid] > x) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++) {
            if(bS(matrix[i], target)) return true;
        }
        return false;
    }
}
