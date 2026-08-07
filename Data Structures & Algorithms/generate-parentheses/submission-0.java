class Solution {
    public void solve(StringBuilder cur, int oCnt, int cCnt, int n, List<String> result) {
        if(cur.length() == n * 2) {
            result.add(cur.toString());
            return;
        }

        if(oCnt < n) {
            cur.append('(');
            solve(cur, oCnt + 1, cCnt, n, result);
            cur.deleteCharAt(cur.length() - 1);
        }

        if(cCnt < oCnt) {
            cur.append(')');
            solve(cur, oCnt, cCnt + 1, n, result);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(new StringBuilder(), 0, 0, n, result);
        return result;
    }
}
