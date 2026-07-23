class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int l = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            count[c - 'A']++;
            maxFreq = Math.max(maxFreq, count[c - 'A']);

            while((r - l + 1) - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}
