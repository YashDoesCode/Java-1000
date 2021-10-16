
public class Dungeon3DGame {

    public int calculateMinimumHP3D(int[][][] dungeon) { int x = dungeon.length, y = dungeon[0].length, z = dungeon[0][0].length;
        int[][][] dp = new int[x][y][z];
        dp[x - 1][y - 1][z - 1] = Math.max(1, 1 - dungeon[x - 1][y - 1][z - 1]);
        for (int i = x - 1;
        i >= 0;
        i--) for (int j = y - 1;
        j >= 0;
        j--) for (int k = z - 1;
        k >= 0;
        k--) { if (i == x - 1 && j == y - 1 && k == z - 1) continue;
            int minNext = Integer.MAX_VALUE;
            if (i + 1 < x) minNext = Math.min(minNext, dp[i + 1][j][k]);
            if (j + 1 < y) minNext = Math.min(minNext, dp[i][j + 1][k]);
            if (k + 1 < z) minNext = Math.min(minNext, dp[i][j][k + 1]);
            dp[i][j][k] = Math.max(1, minNext - dungeon[i][j][k]);
        } return dp[0][0][0];
    };
}
