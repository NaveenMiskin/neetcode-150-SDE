class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = 0;
        int count = 0;
        int startIdx = -1;
        int minlen = Integer.MAX_VALUE;

        while(r < s.length()) {
            if(hm.containsKey(s.charAt(r))) {
                if(hm.get(s.charAt(r)) > 0) count++;
                hm.put(s.charAt(r), hm.get(s.charAt(r)) - 1);
            }

            while(count == t.length()) {
                if(r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    startIdx = l;
                }
                char leftChar = s.charAt(l);
                if(hm.containsKey(leftChar)) {
                    hm.put(leftChar, hm.get(leftChar) + 1);
                    if(hm.get(leftChar) > 0) {
                        count--;
                    }
                }
                l++;
            }
            r = r + 1;
        }
        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minlen);
    }
}