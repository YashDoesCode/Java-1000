public class BurstBalloonsTopicDP {

    public int maxCoins(int[] nums) { int n = nums.length;
        int[] a = new int[n + 2];
        a[0] = a[n + 1] = 1;
        for (int i = 0;
        i < n;
        i++) a[i + 1] = nums[i];
        int[][] dp = new int[n + 2][n + 2];
        for (int k = 1;
        k <= n;
        k++) for (int left = 1;
        left <= n - k + 1;
        left++) { int right = left + k - 1;
            for (int i = left;
            i <= right;
            i++) dp[left][right] = Math.max(dp[left][right], a[left - 1] * a[i] * a[right + 1] + dp[left][i - 1] + dp[i + 1][right]);
        } return dp[1][n];
    };
}
