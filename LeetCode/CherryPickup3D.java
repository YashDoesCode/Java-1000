
import java.util.*;
public class CherryPickup3D {

    public int cherryPickup(int[][] grid) { int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for (int[][] layer : dp) for (int[] row : layer) Arrays.fill(row, -1);
        return Math.max(0, solve(grid, dp, 0, 0, 0, n));
    } private int solve(int[][] g, int[][][] dp, int r1, int c1, int c2, int n) { int r2 = r1 + c1 - c2;
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n || g[r1][c1] == -1 || g[r2][c2] == -1) return -999999;
        if (r1 == n - 1 && c1 == n - 1) return g[r1][c1];
        if (dp[r1][c1][c2] != -1) return dp[r1][c1][c2];
        int val = (r1 == r2 && c1 == c2) ? g[r1][c1] : g[r1][c1] + g[r2][c2];
        int maxV = Math.max(Math.max(solve(g, dp, r1 + 1, c1, c2, n), solve(g, dp, r1 + 1, c1, c2 + 1, n)), Math.max(solve(g, dp, r1, c1 + 1, c2, n), solve(g, dp, r1, c1 + 1, c2 + 1, n)));
        val += maxV;
        return dp[r1][c1][c2] = val;
    };
}
