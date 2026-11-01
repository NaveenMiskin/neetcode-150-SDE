class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int num : asteroids) {
            while(!st.isEmpty() && num < 0 && st.peek() > 0) {
                int sum = num + st.peek();

                if(sum < 0) {
                    st.pop();
                } else if(sum > 0) {
                    num = 0;
                } else {
                    st.pop();
                    num = 0;
                }
            }
            if(num != 0) st.push(num);
        }
        int[] res = new int[st.size()];
        for(int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}