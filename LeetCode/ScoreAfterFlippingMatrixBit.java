
public class ScoreAfterFlippingMatrixBit {

    public int matrixScore(int[][] grid) { int m = grid.length, n = grid[0].length;
        int res = (1 << (n - 1)) * m;
        for (int j = 1;
        j < n;
        j++) { int cur = 0;
            for (int i = 0;
            i < m;
            i++) cur += grid[i][j] ^ grid[i][0];
            res += Math.max(cur, m - cur) * (1 << (n - 1 - j));
        } return res;
    };
}
