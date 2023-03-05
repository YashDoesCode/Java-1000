
public class ProjectionArea3D {

    public int projectionArea(int[][] grid) { int n = grid.length, res = 0;
        for (int i = 0;
        i < n;
        i++) { int bestR = 0, bestC = 0;
            for (int j = 0;
            j < n;
            j++) { if (grid[i][j] > 0) res++;
                bestR = Math.max(bestR, grid[i][j]);
                bestC = Math.max(bestC, grid[j][i]);
            } res += bestR + bestC;
        } return res;
    };
}
