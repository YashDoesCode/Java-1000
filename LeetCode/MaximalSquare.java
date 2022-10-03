
public class MaximalSquare {

    public int maximalSquare(char[][] m) { if (m.length == 0) return 0;
        int r = m.length, c = m[0].length, maxV = 0;
        int[][] dp = new int[r + 1][c + 1];
        for (int i = 1;
        i <= r;
        i++) { for (int j = 1;
            j <= c;
            j++) { if (m[i - 1][j - 1] == '1') { dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxV = Math.max(maxV, dp[i][j]);
                } } } return maxV * maxV;
    };
}
