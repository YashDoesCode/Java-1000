public class Matrix3DMaxMin {

    public int[] findMaxMin3D(int[][][] g) { int maxV = g[0][0][0], minV = g[0][0][0];
        for (int i = 0;
        i < g.length;
        i++) for (int j = 0;
        j < g[0].length;
        j++) for (int k = 0;
        k < g[0][0].length;
        k++) { maxV = Math.max(maxV, g[i][j][k]);
            minV = Math.min(minV, g[i][j][k]);
        } return new int[]{maxV, minV};
    };
}
