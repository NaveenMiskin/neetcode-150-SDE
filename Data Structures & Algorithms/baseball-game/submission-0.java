class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String s : operations) {
            if(s.equals("+")) {
                int top = st.pop();
                int newtop = top + st.peek();
                st.push(top);
                st.push(newtop);
            } else if(s.equals("D")) {
                st.push(2 * st.peek());
            } else if(s.equals("C")) {
                st.pop();
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        int total = 0;
        while(!st.isEmpty()) {
            total += st.pop();
        }
        return total;
    }
}