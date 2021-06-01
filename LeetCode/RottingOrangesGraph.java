
import java.util.*;
public class RottingOrangesGraph {

    public int orangesRotting(int[][] grid) { int r = grid.length, c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0;
        i < r;
        i++) for (int j = 0;
        j < c;
        j++) { if (grid[i][j] == 2) q.add(new int[]{i, j});
            else if (grid[i][j] == 1) fresh++;
        } if (fresh == 0) return 0;
        int mins = 0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) { int size = q.size();
            boolean rotted = false;
            for (int i = 0;
            i < size;
            i++) { int[] cur = q.poll();
                for (int[] d : dirs) { int nx = cur[0] + d[0], ny = cur[1] + d[1];
                    if (nx >= 0 && ny >= 0 && nx < r && ny < c && grid[nx][ny] == 1) { grid[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                        fresh--;
                        rotted = true;
                    } } } if (rotted) mins++;
        } return fresh == 0 ? mins : -1;
    };
}
