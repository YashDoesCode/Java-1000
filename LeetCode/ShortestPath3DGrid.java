
import java.util.*;
public class ShortestPath3DGrid {

    public int shortestPath(int[][][] grid) { int x = grid.length, y = grid[0].length, z = grid[0][0].length;
        boolean[][][] vis = new boolean[x][y][z];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});
        vis[0][0][0] = true;
        int[][] dirs = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
        while (!q.isEmpty()) { int[] cur = q.poll();
            if (cur[0] == x - 1 && cur[1] == y - 1 && cur[2] == z - 1) return cur[3];
            for (int[] d : dirs) { int nx = cur[0] + d[0], ny = cur[1] + d[1], nz = cur[2] + d[2];
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < x && ny < y && nz < z && !vis[nx][ny][nz] && grid[nx][ny][nz] == 0) { vis[nx][ny][nz] = true;
                    q.add(new int[]{nx, ny, nz, cur[3] + 1});
                } } } return -1;
    };
}
