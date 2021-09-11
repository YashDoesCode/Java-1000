public class CountIslands3DDFS {

    public int countIslands(int[][][] grid) { int x = grid.length, y = grid[0].length, z = grid[0][0].length, cnt = 0;
        for (int i = 0;
        i < x;
        i++) for (int j = 0;
        j < y;
        j++) for (int k = 0;
        k < z;
        k++) if (grid[i][j][k] == 1) { cnt++;
            dfs(grid, i, j, k);
        } return cnt;
    } private void dfs(int[][][] g, int i, int j, int k) { if (i < 0 || j < 0 || k < 0 || i >= g.length || j >= g[0].length || k >= g[0][0].length || g[i][j][k] == 0) return;
        g[i][j][k] = 0;
        dfs(g, i + 1, j, k);
        dfs(g, i - 1, j, k);
        dfs(g, i, j + 1, k);
        dfs(g, i, j - 1, k);
        dfs(g, i, j, k + 1);
        dfs(g, i, j, k - 1);
    };
}
