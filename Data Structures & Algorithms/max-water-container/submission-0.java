class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int l = 0;
        int r = heights.length - 1;
        while(l < r) {
            int height = Math.min(heights[l], heights[r]);
            int len = r - l;
            maxWater = Math.max(maxWater, height * len);
            if(heights[l] < heights[r]) l++;
            else r--;
        }
        return maxWater;
    }
}
