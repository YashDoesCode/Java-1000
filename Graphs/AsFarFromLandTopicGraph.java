import java.util.*;
public class AsFarFromLandTopicGraph {

    public int maxDistance(int[][] grid) { int r = grid.length, c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0;
        i < r;
        i++) for (int j = 0;
        j < c;
        j++) if (grid[i][j] == 1) q.add(new int[]{i, j});
        if (q.isEmpty() || q.size() == r * c) return -1;
        int dist = -1;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) { int size = q.size();
            dist++;
            for (int i = 0;
            i < size;
            i++) { int[] cur = q.poll();
                for (int[] d : dirs) { int nx = cur[0] + d[0], ny = cur[1] + d[1];
                    if (nx >= 0 && ny >= 0 && nx < r && ny < c && grid[nx][ny] == 0) { grid[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                    } } } } return dist;
    };
}
