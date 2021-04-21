
public class Path3DGridCount {

    public int uniquePaths3D(int x, int y, int z) { int[][][] dp = new int[x][y][z];
        for (int i = 0;
        i < x;
        i++) for (int j = 0;
        j < y;
        j++) for (int k = 0;
        k < z;
        k++) { if (i == 0 && j == 0 && k == 0) dp[i][j][k] = 1;
            else { int val = 0;
                if (i > 0) val += dp[i - 1][j][k];
                if (j > 0) val += dp[i][j - 1][k];
                if (k > 0) val += dp[i][j][k - 1];
                dp[i][j][k] = val;
            } } return dp[x - 1][y - 1][z - 1];
    };
}
