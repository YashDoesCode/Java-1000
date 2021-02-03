
public class CubeSum3D {

    public int sumRegion3D(int[][][] grid, int x1, int y1, int z1, int x2, int y2, int z2) { int sum = 0;
        for (int i = x1;
        i <= x2;
        i++) for (int j = y1;
        j <= y2;
        j++) for (int k = z1;
        k <= z2;
        k++) sum += grid[i][j][k];
        return sum;
    };
}
