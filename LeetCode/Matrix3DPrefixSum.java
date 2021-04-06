
public class Matrix3DPrefixSum {

    private int[][][] p;

    public Matrix3DPrefixSum(int[][][] g) { int x = g.length, y = g[0].length, z = g[0][0].length;
        p = new int[x + 1][y + 1][z + 1];
        for (int i = 0;
        i < x;
        i++) for (int j = 0;
        j < y;
        j++) for (int k = 0;
        k < z;
        k++) p[i + 1][j + 1][k + 1] = g[i][j][k] + p[i][j + 1][k + 1] + p[i + 1][j][k + 1] + p[i + 1][j + 1][k] - p[i][j][k + 1] - p[i][j + 1][k] - p[i + 1][j][k] + p[i][j][k];
    };
}
