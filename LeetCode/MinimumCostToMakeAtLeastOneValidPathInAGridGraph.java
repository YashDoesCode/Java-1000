
import java.util.*;
public class MinimumCostToMakeAtLeastOneValidPathInAGridGraph {

    public int minCost(int[][] grid) { int r = grid.length, c = grid[0].length;
        int[][] cost = new int[r][c];
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);
        cost[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[]{0, 0, 0});
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while (!pq.isEmpty()) { int[] cur = pq.poll();
            int x = cur[0], y = cur[1], w = cur[2];
            if (x == r - 1 && y == c - 1) return w;
            for (int i = 0;
            i < 4;
            i++) { int nx = x + dirs[i][0], ny = y + dirs[i][1];
                int extra = (grid[x][y] == i + 1) ? 0 : 1;
                if (nx >= 0 && ny >= 0 && nx < r && ny < c && w + extra < cost[nx][ny]) { cost[nx][ny] = w + extra;
                    pq.add(new int[]{nx, ny, cost[nx][ny]});
                } } } return 0;
    };
}
