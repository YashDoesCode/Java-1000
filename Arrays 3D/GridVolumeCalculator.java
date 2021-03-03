public class GridVolumeCalculator {

    public double calculateVolume(double[][][] grid) {
        double total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                for (int k = 0; k < grid[0][0].length; k++) {
                    total += grid[i][j][k];
                }
            }
        }
        return total;
    }
}
