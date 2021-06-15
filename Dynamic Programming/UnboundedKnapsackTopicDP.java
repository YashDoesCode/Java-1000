public class UnboundedKnapsackTopicDP {

    public int knapsack(int W, int[] wt, int[] val, int n) { int[] dp = new int[W + 1];
        for (int i = 0;
        i <= W;
        i++) for (int j = 0;
        j < n;
        j++) if (wt[j] <= i) dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
        return dp[W];
    };
}
