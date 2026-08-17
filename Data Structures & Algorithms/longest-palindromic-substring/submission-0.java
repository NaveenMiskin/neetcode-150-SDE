class Solution {
    private int expandAroundCenter(String s, int l, int r) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2) return s;
        
        int st = 0, ed = 0;
        for(int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if(len > ed - st) {
                st = i - (len - 1) / 2;
                ed = i + len / 2;
            }
        }
        return s.substring(st, ed + 1);
    }
}
