class Solution {
    public void solve(int idx, String digits, String[] map, StringBuilder curr, List<String> res) {
        if(idx == digits.length()) {
            res.add(curr.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String letters = map[digit - '0'];

        for(int i = 0; i < letters.length(); i++) {
            curr.append(letters.charAt(i));

            solve(idx + 1, digits, map, curr, res);

            curr.deleteCharAt(curr.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits.length() == 0) return res;

        String[] map = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        solve(0, digits, map, new StringBuilder(), res);
        return res;
    }
}
