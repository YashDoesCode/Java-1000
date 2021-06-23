public class MagicSquare2D {

    public boolean isMagicSquare(int[][] grid) { int sum = grid[0][0] + grid[0][1] + grid[0][2];
        for (int i = 0;
        i < 3;
        i++) { if (grid[i][0] + grid[i][1] + grid[i][2] != sum) return false;
            if (grid[0][i] + grid[1][i] + grid[2][i] != sum) return false;
        } if (grid[0][0] + grid[1][1] + grid[2][2] != sum) return false;
        if (grid[0][2] + grid[1][1] + grid[2][0] != sum) return false;
        return true;
    };
}
