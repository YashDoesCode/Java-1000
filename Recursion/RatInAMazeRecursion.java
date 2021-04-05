import java.util.*;
public class RatInAMazeRecursion {

    public List<String> findPath(int[][] m, int n) { List<String> res = new ArrayList<>();
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0) return res;
        boolean[][] vis = new boolean[n][n];
        dfs(m, n, 0, 0, "", vis, res);
        return res;
    } private void dfs(int[][] m, int n, int r, int c, String path, boolean[][] vis, List<String> res) { if (r == n - 1 && c == n - 1) { res.add(path);
            return;
        } vis[r][c] = true;
        if (r + 1 < n && m[r + 1][c] == 1 && !vis[r + 1][c]) dfs(m, n, r + 1, c, path + "D", vis, res);
        if (c - 1 >= 0 && m[r][c - 1] == 1 && !vis[r][c - 1]) dfs(m, n, r, c - 1, path + "L", vis, res);
        if (c + 1 < n && m[r][c + 1] == 1 && !vis[r][c + 1]) dfs(m, n, r, c + 1, path + "R", vis, res);
        if (r - 1 >= 0 && m[r - 1][c] == 1 && !vis[r - 1][c]) dfs(m, n, r - 1, c, path + "U", vis, res);
        vis[r][c] = false;
    };
}
