












//Memoization
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int[] row : dp) {
    Arrays.fill(row, -1);
}
        int ans = f(coins, coins.length - 1, amount, dp);
        if (ans > Integer.MAX_VALUE - 50) {
            return -1;
        }
        return ans;
    }

    int f(int[] coins, int idx, int t, int[][] dp) {
        if (idx == 0) {
            if (t % coins[0] == 0)
                return t / coins[0];
            else {
                return Integer.MAX_VALUE - 10;
            }
        }

        if (dp[idx][t] == -1) {
            int notTake = 0 + f(coins, idx - 1, t, dp);
            int take = Integer.MAX_VALUE - 10;
            if (coins[idx] <= t) {
                take = 1 + f(coins, idx, t - coins[idx], dp);
            }

            return Math.min(take, notTake);
        }
        else{
            return dp[idx][t];
        }

    }

}
