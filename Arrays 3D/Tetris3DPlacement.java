public class Tetris3DPlacement {

    public boolean canPlace(int[][][] grid, int x, int y, int z, int dx, int dy, int dz) { for (int i = x;
        i < x + dx;
        i++) for (int j = y;
        j < y + dy;
        j++) for (int k = z;
        k < z + dz;
        k++) if (i >= grid.length || j >= grid[0].length || k >= grid[0][0].length || grid[i][j][k] != 0) return false;
        return true;
    };
}
