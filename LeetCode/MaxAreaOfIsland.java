
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) { int maxV = 0;
        for (int i = 0;
        i < grid.length;
        i++) for (int j = 0;
        j < grid[0].length;
        j++) if (grid[i][j] == 1) maxV = Math.max(maxV, dfs(grid, i, j));
        return maxV;
    } private int dfs(int[][] g, int r, int c) { if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] == 0) return 0;
        g[r][c] = 0;
        return 1 + dfs(g, r + 1, c) + dfs(g, r - 1, c) + dfs(g, r, c + 1) + dfs(g, r, c - 1);
    };
}
