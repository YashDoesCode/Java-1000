import java.util.*;

public class RatInMazeRecursion {

    public List<String> findPath(int[][] m, int n) {
        List<String> res = new ArrayList<>();
        if (m[0][0] == 0 || m[n - 1][n - 1] == 0) return res;
        boolean[][] visited = new boolean[n][n];
        solve(0, 0, m, n, "", res, visited);
        return res;
    }

    private void solve(int r, int c, int[][] m, int n, String path, List<String> res, boolean[][] vis) {
        if (r == n - 1 && c == n - 1) {
            res.add(path);
            return;
        }
        vis[r][c] = true;
        if (r + 1 < n && m[r + 1][c] == 1 && !vis[r + 1][c]) solve(r + 1, c, m, n, path + "D", res, vis);
        if (c - 1 >= 0 && m[r][c - 1] == 1 && !vis[r][c - 1]) solve(r, c - 1, m, n, path + "L", res, vis);
        if (c + 1 < n && m[r][c + 1] == 1 && !vis[r][c + 1]) solve(r, c + 1, m, n, path + "R", res, vis);
        if (r - 1 >= 0 && m[r - 1][c] == 1 && !vis[r - 1][c]) solve(r - 1, c, m, n, path + "U", res, vis);
        vis[r][c] = false;
    }
}
