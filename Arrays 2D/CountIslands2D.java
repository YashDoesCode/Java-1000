public class CountIslands2D {

    public int numIslands(char[][] g) { int cnt = 0;
        for (int i = 0;
        i < g.length;
        i++) for (int j = 0;
        j < g[0].length;
        j++) if (g[i][j] == '1') { cnt++;
            dfs(g, i, j);
        } return cnt;
    } private void dfs(char[][] g, int r, int c) { if (r < 0 || c < 0 || r >= g.length || c >= g[0].length || g[r][c] == '0') return;
        g[r][c] = '0';
        dfs(g, r + 1, c);
        dfs(g, r - 1, c);
        dfs(g, r, c + 1);
        dfs(g, r, c - 1);
    };
}
