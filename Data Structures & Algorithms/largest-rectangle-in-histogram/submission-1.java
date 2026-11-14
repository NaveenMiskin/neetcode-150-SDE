class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int largestRectangle = 0;

        for(int i = 0; i < heights.length; i++) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int top = st.pop();
                int nse = i;
                int pse = (st.isEmpty()) ? -1 : st.peek();

                largestRectangle = Math.max(largestRectangle, heights[top] * (nse - pse - 1));
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int top = st.pop();
            int nse = heights.length;
            int pse = (st.isEmpty()) ? -1 : st.peek();

            largestRectangle = Math.max(largestRectangle, heights[top] * (nse - pse - 1));
        }
        return largestRectangle;
    }
}
