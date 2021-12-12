import java.util.*;
public class DetectCycleUndirectedGraph {

    public boolean isCyclic(int n, List<List<Integer>> adj) { boolean[] vis = new boolean[n];
        for (int i = 0;
        i < n;
        i++) if (!vis[i]) if (dfs(i, -1, adj, vis)) return true;
        return false;
    } private boolean dfs(int u, int p, List<List<Integer>> adj, boolean[] vis) { vis[u] = true;
        for (int v : adj.get(u)) { if (!vis[v]) { if (dfs(v, u, adj, vis)) return true;
            } else if (v != p) return true;
        } return false;
    };
}
