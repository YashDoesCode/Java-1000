public class CountNegatives2D {

    public int countNegatives(int[][] grid) { int r = grid.length, c = grid[0].length, cnt = 0, row = r - 1, col = 0;
        while (row >= 0 && col < c) { if (grid[row][col] < 0) { cnt += c - col;
                row--;
            } else col++;
        } return cnt;
    };
}
