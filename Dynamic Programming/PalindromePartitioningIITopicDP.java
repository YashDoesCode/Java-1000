public class PalindromePartitioningIITopicDP {

    public int minCut(String s) { int n = s.length();
        boolean[][] pal = new boolean[n][n];
        int[] dp = new int[n];
        for (int i = 0;
        i < n;
        i++) { int minC = i;
            for (int j = 0;
            j <= i;
            j++) if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || pal[j + 1][i - 1])) { pal[j][i] = true;
                minC = (j == 0) ? 0 : Math.min(minC, dp[j - 1] + 1);
            } dp[i] = minC;
        } return dp[n - 1];
    };
}
