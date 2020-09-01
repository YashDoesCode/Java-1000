public class MaxCubeSubarraySum3D {

    public int maxSubarraySum(int[][][] g) { int x = g.length, maxV = g[0][0][0];
        for (int i = 0;
        i < x;
        i++) for (int j = 0;
        j < g[0].length;
        j++) for (int k = 0;
        k < g[0][0].length;
        k++) maxV = Math.max(maxV, g[i][j][k]);
        return maxV;
    };
}
