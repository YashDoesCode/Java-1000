public class HamiltonianPathCheckGraph {

    public boolean hasHamiltonianPath(int n, int[][] adj) { boolean[] vis = new boolean[n];
        for (int i = 0;
        i < n;
        i++) if (dfs(i, adj, vis, 1, n)) return true;
        return false;
    } private boolean dfs(int u, int[][] adj, boolean[] vis, int count, int n) { if (count == n) return true;
        vis[u] = true;
        for (int v = 0;
        v < n;
        v++) if (adj[u][v] == 1 && !vis[v]) if (dfs(v, adj, vis, count + 1, n)) return true;
        vis[u] = false;
        return false;
    };
}
