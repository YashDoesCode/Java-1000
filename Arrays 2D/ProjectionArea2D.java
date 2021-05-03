public class ProjectionArea2D {

    public int projectionArea(int[][] grid) { int n = grid.length, res = 0;
        for (int i = 0;
        i < n;
        i++) { int rMax = 0, cMax = 0;
            for (int j = 0;
            j < n;
            j++) { if (grid[i][j] > 0) res++;
                rMax = Math.max(rMax, grid[i][j]);
                cMax = Math.max(cMax, grid[j][i]);
            } res += rMax + cMax;
        } return res;
    };
}
