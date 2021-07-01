
public class GridDP3D {

    public int maxPath3D(int[][][] grid) { int x = grid.length, y = grid[0].length, z = grid[0][0].length;
        int[][][] dp = new int[x][y][z];
        dp[0][0][0] = grid[0][0][0];
        for (int i = 0;
        i < x;
        i++) for (int j = 0;
        j < y;
        j++) for (int k = 0;
        k < z;
        k++) { if (i == 0 && j == 0 && k == 0) continue;
            int maxPrev = 0;
            if (i > 0) maxPrev = Math.max(maxPrev, dp[i - 1][j][k]);
            if (j > 0) maxPrev = Math.max(maxPrev, dp[i][j - 1][k]);
            if (k > 0) maxPrev = Math.max(maxPrev, dp[i][j][k - 1]);
            dp[i][j][k] = maxPrev + grid[i][j][k];
        } return dp[x - 1][y - 1][z - 1];
    };
}
