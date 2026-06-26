class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int maxlen = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            while(hs.contains(s.charAt(r))) {
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(s.charAt(r));
            maxlen = Math.max(maxlen, r - l + 1);
        }
        return maxlen;
    }
}
