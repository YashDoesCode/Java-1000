public class Rotate3DCube {

    public int[][][] rotateX(int[][][] g) { int x = g.length, y = g[0].length, z = g[0][0].length;
        int[][][] res = new int[x][z][y];
        for (int i = 0;
        i < x;
        i++) for (int j = 0;
        j < y;
        j++) for (int k = 0;
        k < z;
        k++) res[i][k][y - 1 - j] = g[i][j][k];
        return res;
    };
}
