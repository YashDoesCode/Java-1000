public class Matrix3DInit {

    public int[][][] create3D(int x, int y, int z) { int[][][] g = new int[x][y][z];
        int val = 1;
        for (int i = 0;
        i < x;
        i++) for (int j = 0;
        j < y;
        j++) for (int k = 0;
        k < z;
        k++) g[i][j][k] = val++;
        return g;
    };
}
