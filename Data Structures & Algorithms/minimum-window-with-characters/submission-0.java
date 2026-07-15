class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        int minlen = Integer.MAX_VALUE;
        int stIdx = -1;
        for(int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> hm = new HashMap<>();
            int count = 0;
            for(int j = 0; j < t.length(); j++) {
                hm.put(t.charAt(j), hm.getOrDefault(t.charAt(j), 0) + 1);
            }

            for(int j = i; j < s.length(); j++) {
                if(hm.containsKey(s.charAt(j))) {
                    if(hm.get(s.charAt(j)) > 0) {
                        count++;
                    }
                    hm.put(s.charAt(j), hm.get(s.charAt(j)) - 1);
                }

                if(count == t.length()) {
                    if(j - i + 1 < minlen) {
                        minlen = j - i + 1;
                        stIdx = i;
                        break;
                    }
                }
            }
        }
        return stIdx == -1 ? "" : s.substring(stIdx, stIdx + minlen);
    }
}