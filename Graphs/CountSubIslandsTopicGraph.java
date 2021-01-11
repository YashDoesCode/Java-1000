public class CountSubIslandsTopicGraph {

    public int countSubIslands(int[][] grid1, int[][] grid2) { int cnt = 0;
        for (int i = 0;
        i < grid2.length;
        i++) for (int j = 0;
        j < grid2[0].length;
        j++) if (grid2[i][j] == 1) if (dfs(grid1, grid2, i, j)) cnt++;
        return cnt;
    } private boolean dfs(int[][] g1, int[][] g2, int r, int c) { if (r < 0 || c < 0 || r >= g2.length || c >= g2[0].length || g2[r][c] == 0) return true;
        g2[r][c] = 0;
        boolean res = (g1[r][c] == 1);
        boolean b1 = dfs(g1, g2, r + 1, c), b2 = dfs(g1, g2, r - 1, c), b3 = dfs(g1, g2, r, c + 1), b4 = dfs(g1, g2, r, c - 1);
        return res && b1 && b2 && b3 && b4;
    };
}
