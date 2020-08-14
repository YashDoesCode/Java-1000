public class OutOfBoundaryPathsTopicDP {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) { int MOD = 1000000007;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int ans = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int moves = 1;
        moves <= maxMove;
        moves++) { int[][] temp = new int[m][n];
            for (int r = 0;
            r < m;
            r++) for (int c = 0;
            c < n;
            c++) if (dp[r][c] > 0) for (int[] d : dirs) { int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) ans = (ans + dp[r][c]) % MOD;
                else temp[nr][nc] = (temp[nr][nc] + dp[r][c]) % MOD;
            } dp = temp;
        } return ans;
    };
}
