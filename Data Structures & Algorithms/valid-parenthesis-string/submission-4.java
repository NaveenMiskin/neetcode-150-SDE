class Solution {
    public boolean checkValidString(String s) {
        int leftmin = 0;
        int leftmax = 0;

        for(char ch : s.toCharArray()) {
            if (ch == '(') {
                leftmin++;
                leftmax++;
            } else if (ch == ')') {
                leftmin--;
                leftmax--;
            } else {
                leftmin--;
                leftmax++;
            }

            if(leftmax < 0) return false;
            if(leftmin < 0) leftmin = 0;
        }
        return leftmin == 0;
    }
}
