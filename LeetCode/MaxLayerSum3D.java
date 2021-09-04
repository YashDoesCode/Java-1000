
public class MaxLayerSum3D {

    public int maxLayerSum(int[][][] grid) { int x = grid.length, maxV = Integer.MIN_VALUE;
        for (int i = 0;
        i < x;
        i++) { int sum = 0;
            for (int j = 0;
            j < grid[0].length;
            j++) for (int k = 0;
            k < grid[0][0].length;
            k++) sum += grid[i][j][k];
            maxV = Math.max(maxV, sum);
        } return maxV;
    };
}
