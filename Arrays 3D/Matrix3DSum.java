public class Matrix3DSum {

    public int sum3D(int[][][] g) { int sum = 0;
        for (int i = 0;
        i < g.length;
        i++) for (int j = 0;
        j < g[0].length;
        j++) for (int k = 0;
        k < g[0][0].length;
        k++) sum += g[i][j][k];
        return sum;
    };
}
