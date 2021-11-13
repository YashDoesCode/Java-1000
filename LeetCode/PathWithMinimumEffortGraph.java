
import java.util.*;
public class PathWithMinimumEffortGraph {

    public int minimumEffortPath(int[][] heights) { int r = heights.length, c = heights[0].length;
        int[][] effort = new int[r][c];
        for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[]{0, 0, 0});
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) { int[] cur = pq.poll();
            int x = cur[0], y = cur[1], eff = cur[2];
            if (x == r - 1 && y == c - 1) return eff;
            for (int[] d : dirs) { int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && ny >= 0 && nx < r && ny < c) { int newEff = Math.max(eff, Math.abs(heights[nx][ny] - heights[x][y]));
                    if (newEff < effort[nx][ny]) { effort[nx][ny] = newEff;
                        pq.add(new int[]{nx, ny, newEff});
                    } } } } return 0;
    };
}
