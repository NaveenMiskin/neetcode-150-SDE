class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> ls = new Stack<>();
        Stack<Integer> ss = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                ls.push(i);
            } else if (ch == '*') {
                ss.push(i);
            } else {
                if (!ls.isEmpty()) {
                    ls.pop();
                } else if (!ss.isEmpty()) {
                    ss.pop();
                } else {
                    return false;
                }
            }
        }

        while(!ls.isEmpty() && !ss.isEmpty()) {
            if(ls.pop() > ss.pop()) {
                return false;
            }
        }

        return ls.isEmpty();
    }
}
