
import java.util.*;
public class Shift2DGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) { int m = grid.length, n = grid[0].length, total = m * n;
        k %= total;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0;
        i < m;
        i++) { List<Integer> row = new ArrayList<>();
            for (int j = 0;
            j < n;
            j++) { int idx = (i * n + j - k + total) % total;
                row.add(grid[idx / n][idx % n]);
            } res.add(row);
        } return res;
    };
}
