
public class NumberOfProvincesGraph {

    public int findCircleNum(int[][] isConnected) { int n = isConnected.length, cnt = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0;
        i < n;
        i++) if (!vis[i]) { cnt++;
            dfs(isConnected, vis, i);
        } return cnt;
    } private void dfs(int[][] g, boolean[] vis, int u) { vis[u] = true;
        for (int v = 0;
        v < g.length;
        v++) if (g[u][v] == 1 && !vis[v]) dfs(g, vis, v);
    };
}
