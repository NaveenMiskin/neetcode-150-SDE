class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int n = s.length();

        int[] freq = new int[26];
        for(int i = 0; i < n; i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            freq[schar - 'a']++;
            freq[tchar - 'a']--;
        }

        for(int cnt : freq) {
            if(cnt != 0) return false;
        }
        return true;
    }
}
