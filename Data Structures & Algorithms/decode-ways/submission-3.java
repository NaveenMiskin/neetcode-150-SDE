class Solution {
    int solve(int ind, String s, int[] dp) {
        if(ind == s.length()) {
            return 1;
        }

        if(dp[ind] != -1) {
            return dp[ind];
        }

        if(s.charAt(ind) == '0') {
            return 0;
        }

        int ways = solve(ind + 1, s, dp);
        if(ind + 1 < s.length() && (s.charAt(ind) == '1' || 
            (s.charAt(ind) == '2' && s.charAt(ind + 1) <= '6'))) {
                    ways += solve(ind + 2, s, dp);
        }
        return dp[ind] = ways;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(0, s, dp);
    }
}
