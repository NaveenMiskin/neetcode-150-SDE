class Solution {
    public int solve(int i, int j, String s1, String s2, int[][] dp) {
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            return 0 + solve(i - 1, j - 1, s1, s2, dp);
        }
        int insert = 1 + solve(i, j - 1, s1, s2, dp);
        int delete = 1 + solve(i - 1, j, s1, s2, dp);
        int replace = 1 + solve(i - 1, j - 1, s1, s2, dp);

        return dp[i][j] = Math.min(insert, Math.min(delete, replace));
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // int[][] dp = new int[m + 1][n + 1];
        int[] prev = new int[n + 1];
        int[] cur = new int[n + 1];

        for(int j = 0; j <= n; j++) {
            prev[j] = j;
        }

        for(int i = 1; i <= m; i++) {
            cur[0] = i;
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = prev[j - 1];
                } else {
                    int insert = 1 + cur[j - 1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j - 1];

                    cur[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = cur.clone();
            cur = new int[n + 1];
        }
        return prev[n];
    }
}
