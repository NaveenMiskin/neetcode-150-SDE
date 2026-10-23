class Solution {
    private boolean isVaild(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return isVaild(s, i + 1, j) || 
                        isVaild(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }
}