/*
 * Popular Question: Coin Change (Minimum Coins to Make Amount)
 * Source: LeetCode #322 (Medium) & GeeksforGeeks
 *
 * Problem Statement:
 * You are given an integer array coins representing coins of different denominations and an integer amount
 * representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be
 * made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 * Constraints:
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2^31 - 1
 * 0 <= amount <= 10^4
 */

import java.util.Arrays;

public class CoinChangeTopicDP {

    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        int maxVal = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, maxVal);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChangeMemoized(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return solveMemo(coins, amount, memo);
    }

    private int solveMemo(int[] coins, int rem, int[] memo) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (memo[rem] != -2) {
            return memo[rem];
        }

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = solveMemo(coins, rem - coin, memo);
            if (res >= 0 && res < minCoins) {
                minCoins = res + 1;
            }
        }

        memo[rem] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return memo[rem];
    }

    public static void main(String[] args) {
        CoinChangeTopicDP solver = new CoinChangeTopicDP();

        int[] coins1 = {1, 2, 5};
        int amount1 = 11;

        int[] coins2 = {2};
        int amount2 = 3;

        int res1 = solver.coinChange(coins1, amount1);
        int res2 = solver.coinChange(coins2, amount2);
        int memoRes1 = solver.coinChangeMemoized(coins1, amount1);

        System.out.println("DP Result Test 1: " + res1);
        System.out.println("Memoization Result Test 1: " + memoRes1);
        System.out.println("DP Result Test 2: " + res2);
    }
}
