class Solution {
    public int solve(int i, String s, int[] dp) {
        if(i == s.length()) return 1;
        
        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1) return dp[i];
        int ways = solve(i + 1, s, dp);
        if(i + 1 < s.length() &&
                (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
                        ways += solve(i + 2, s, dp);
                    }
        return dp[i] = ways;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(0, s, dp);
    }
}
