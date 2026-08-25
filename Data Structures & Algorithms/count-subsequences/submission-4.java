class Solution {
    int solve(int i, int j, String s, String t, int[][] dp) {
        if(j < 0) return 1; // all char exausted in t
        if(i < 0) return 0; // still char remaning in t but s got exausted

        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = solve(i - 1, j - 1, s, t, dp) + solve(i - 1, j, s, t, dp);
        } else {
            return dp[i][j] = solve(i - 1, j, s, t, dp);
        }
    }
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // int[][] dp = new int[m + 1][n + 1];
        int[] prev = new int[n + 1];
        int[] cur = new int[n + 1];

        prev[0] = 1;

        for(int i = 1; i <= m; i++) {
            cur[0] = 1;

            for(int j = 1; j <= n; j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    cur[j] = prev[j - 1] + prev[j];
                } else {
                    cur[j] = prev[j];
                }
            }
            prev = cur.clone();
            cur = new int[n + 1];
        }
        return prev[n];
    }
}
