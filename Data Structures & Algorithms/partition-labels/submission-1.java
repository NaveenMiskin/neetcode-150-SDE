class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIdx = new int[26];
        for(int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i) - 'a'] = i;
        }

        List<Integer> res = new ArrayList<>();

        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIdx[s.charAt(i) - 'a']);
            if(i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
