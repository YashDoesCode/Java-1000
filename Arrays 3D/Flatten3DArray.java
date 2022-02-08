public class Flatten3DArray {

    public int[] flatten(int[][][] g) { int x = g.length, y = g[0].length, z = g[0][0].length;
        int[] res = new int[x * y * z];
        int idx = 0;
        for (int i = 0;
        i < x;
        i++) for (int j = 0;
        j < y;
        j++) for (int k = 0;
        k < z;
        k++) res[idx++] = g[i][j][k];
        return res;
    };
}
