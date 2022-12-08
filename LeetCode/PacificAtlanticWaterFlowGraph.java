
import java.util.*;
public class PacificAtlanticWaterFlowGraph {

    public List<List<Integer>> pacificAtlantic(int[][] heights) { List<List<Integer>> res = new ArrayList<>();
        int r = heights.length, c = heights[0].length;
        boolean[][] pac = new boolean[r][c], atl = new boolean[r][c];
        for (int i = 0;
        i < r;
        i++) { dfs(heights, pac, i, 0, 0);
            dfs(heights, atl, i, c - 1, 0);
        } for (int j = 0;
        j < c;
        j++) { dfs(heights, pac, 0, j, 0);
            dfs(heights, atl, r - 1, j, 0);
        } for (int i = 0;
        i < r;
        i++) for (int j = 0;
        j < c;
        j++) if (pac[i][j] && atl[i][j]) res.add(Arrays.asList(i, j));
        return res;
    } private void dfs(int[][] h, boolean[][] vis, int r, int c, int prev) { if (r < 0 || c < 0 || r >= h.length || c >= h[0].length || vis[r][c] || h[r][c] < prev) return;
        vis[r][c] = true;
        dfs(h, vis, r + 1, c, h[r][c]);
        dfs(h, vis, r - 1, c, h[r][c]);
        dfs(h, vis, r, c + 1, h[r][c]);
        dfs(h, vis, r, c - 1, h[r][c]);
    };
}
