class Solution {
    boolean solve(int i, int j, int[] piles, boolean isAlice, int aliceScore, int bobScore, Boolean[][] dp) {
        if(i > j) {
            return aliceScore > bobScore;
        }

        if(dp[i][j] != null) return dp[i][j];

        if(isAlice) {
            Boolean takeleft = solve(i + 1, j, piles, false, aliceScore + piles[i], bobScore, dp);
            Boolean takeright = solve(i, j - 1, piles, false, aliceScore + piles[j], bobScore, dp);

            return dp[i][j] = takeleft || takeright;
        } else {
            Boolean takeleft = solve(i + 1, j, piles, true, aliceScore, bobScore + piles[i], dp);
            Boolean takeright = solve(i, j - 1, piles, true, aliceScore, bobScore + piles[j], dp);

            return dp[i][j] = takeleft || takeright;
        }
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        Boolean[][] dp = new Boolean[n][n];

        return solve(0, piles.length - 1, piles, true, 0, 0, dp);
    }
}