public class Matrix3DTranspose {

    public int[][][] transpose3D(int[][][] g) { int x = g.length, y = g[0].length, z = g[0][0].length;
        int[][][] res = new int[z][y][x];
        for (int i = 0;
        i < x;
        i++) for (int j = 0;
        j < y;
        j++) for (int k = 0;
        k < z;
        k++) res[k][j][i] = g[i][j][k];
        return res;
    };
}
