public class SpatialGrid3D {

    private final double[][][] grid;

    public SpatialGrid3D(int x, int y, int z) {
        this.grid = new double[x][y][z];
    }

    public void setVal(int x, int y, int z, double val) {
        grid[x][y][z] = val;
    }

    public double getVal(int x, int y, int z) {
        return grid[x][y][z];
    }

    public double computeVolumeSum() {
        double sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                for (int k = 0; k < grid[0][0].length; k++) {
                    sum += grid[i][j][k];
                }
            }
        }
        return sum;
    }
}
