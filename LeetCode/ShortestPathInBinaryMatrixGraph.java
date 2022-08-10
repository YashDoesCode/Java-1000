
import java.util.*;
public class ShortestPathInBinaryMatrixGraph {

    public int shortestPathBinaryMatrix(int[][] grid) { int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        grid[0][0] = 1;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        while (!q.isEmpty()) { int[] cur = q.poll();
            int r = cur[0], c = cur[1], d = cur[2];
            if (r == n - 1 && c == n - 1) return d;
            for (int[] dir : dirs) { int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0) { grid[nr][nc] = 1;
                    q.add(new int[]{nr, nc, d + 1});
                } } } return -1;
    };
}
