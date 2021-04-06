public class KnightProbabilityTopicDP {

    public double knightProbability(int n, int k, int row, int column) { double[][] dp = new double[n][n];
        dp[row][column] = 1.0;
        int[][] dirs = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
        while (k-- > 0) { double[][] next = new double[n][n];
            for (int r = 0;
            r < n;
            r++) for (int c = 0;
            c < n;
            c++) if (dp[r][c] > 0) for (int[] d : dirs) { int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n) next[nr][nc] += dp[r][c] / 8.0;
            } dp = next;
        } double ans = 0;
        for (int r = 0;
        r < n;
        r++) for (int c = 0;
        c < n;
        c++) ans += dp[r][c];
        return ans;
    };
}
