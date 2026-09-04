class Solution {
    public boolean solve(int i, String s, List<String> wordDict, Boolean[] dp) {
        int n = s.length();
        if(i == n) return true;

        if(dp[i] != null) return dp[i];

        for(int endIdx = i + 1; endIdx <= n; endIdx++) {
            String split = s.substring(i, endIdx);

            if(wordDict.contains(split) && solve(endIdx, s, wordDict, dp)) {
                return true;
            }
        }
        return dp[i] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Boolean[] dp = new Boolean[n + 1];
        return solve(0, s, wordDict, dp);
    }
}
