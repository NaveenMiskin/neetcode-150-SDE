class Solution {
    public int solve(int i, int target, int[] arr) {
        if(i == 0) {
            if(target % arr[i] == 0) return target / arr[i];
            else return (int)1e9;
        }

        int not_take = 0 + solve(i - 1, target, arr);
        int take = Integer.MAX_VALUE;
        if(arr[i] <= target) {
            take = 1 + solve(i, target - arr[i], arr);
        }
        return Math.min(take, not_take);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = solve(n - 1, amount, coins);
        return (ans >= (int)1e9) ? -1 : ans;
    }
}
