/*
 * Popular Question: 0/1 Knapsack Problem
 * Source: GeeksforGeeks & Classic Dynamic Programming Benchmark
 *
 * Problem Statement:
 * Given N items, each with a given weight wt[i] and a value val[i], and a knapsack of capacity W.
 * Find the maximum total value of items that can be included in the knapsack such that the total weight
 * does not exceed W.
 * Note that you cannot break an item; you either pick the complete item or don't pick it (0-1 property).
 *
 * Example 1:
 * Input: W = 50, val = [60, 100, 120], wt = [10, 20, 30]
 * Output: 220
 * Explanation: Pick items 2 and 3 with weights 20 and 30, total value = 100 + 120 = 220.
 *
 * Constraints:
 * 1 <= N <= 1000
 * 1 <= W <= 1000
 * 1 <= wt[i] <= 1000
 * 1 <= val[i] <= 1000
 */

import java.util.Arrays;

public class Knapsack01TopicDP {

    public int knapsack2D(int W, int[] wt, int[] val, int n) {
        if (W <= 0 || wt == null || val == null || n <= 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public int knapsackSpaceOptimized(int W, int[] wt, int[] val, int n) {
        if (W <= 0 || wt == null || val == null || n <= 0) {
            return 0;
        }

        int[] dp = new int[W + 1];

        for (int i = 0; i < n; i++) {
            for (int w = W; w >= wt[i]; w--) {
                dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
            }
        }

        return dp[W];
    }

    public int knapsackMemoized(int W, int[] wt, int[] val, int n) {
        int[][] memo = new int[n + 1][W + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solveMemo(W, wt, val, n, memo);
    }

    private int solveMemo(int w, int[] wt, int[] val, int i, int[][] memo) {
        if (i == 0 || w == 0) {
            return 0;
        }
        if (memo[i][w] != -1) {
            return memo[i][w];
        }

        if (wt[i - 1] <= w) {
            memo[i][w] = Math.max(
                val[i - 1] + solveMemo(w - wt[i - 1], wt, val, i - 1, memo),
                solveMemo(w, wt, val, i - 1, memo)
            );
        } else {
            memo[i][w] = solveMemo(w, wt, val, i - 1, memo);
        }

        return memo[i][w];
    }

    public static void main(String[] args) {
        Knapsack01TopicDP solver = new Knapsack01TopicDP();

        int W1 = 50;
        int[] val1 = {60, 100, 120};
        int[] wt1 = {10, 20, 30};
        int n1 = val1.length;

        int res2D = solver.knapsack2D(W1, wt1, val1, n1);
        int res1D = solver.knapsackSpaceOptimized(W1, wt1, val1, n1);
        int resMemo = solver.knapsackMemoized(W1, wt1, val1, n1);

        System.out.println("2D DP Knapsack Max Value: " + res2D);
        System.out.println("1D Space Optimized DP Value: " + res1D);
        System.out.println("Memoized DP Knapsack Max Value: " + resMemo);
    }
}
