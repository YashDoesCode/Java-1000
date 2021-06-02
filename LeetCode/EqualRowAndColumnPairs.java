
import java.util.*;
public class EqualRowAndColumnPairs {

    public int equalPairs(int[][] grid) { int n = grid.length, cnt = 0;
        Map<String, Integer> mp = new HashMap<>();
        for (int[] row : grid) { String s = Arrays.toString(row);
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        } for (int c = 0;
        c < n;
        c++) { int[] col = new int[n];
            for (int r = 0;
            r < n;
            r++) col[r] = grid[r][c];
            cnt += mp.getOrDefault(Arrays.toString(col), 0);
        } return cnt;
    };
}
