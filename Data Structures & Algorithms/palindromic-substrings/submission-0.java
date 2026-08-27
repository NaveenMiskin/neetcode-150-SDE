class Solution {
    public int expand(String s, int left, int right) {
        if(left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
            return 0;
        }
        return 1 + expand(s, left - 1, right + 1);
    }
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);

            count += expand(s, i, i + 1);
        }
        return count;
    }
}
