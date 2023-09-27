import java.util.*;
public class DetectCycleDirectedGraph {

    public boolean isCyclic(int n, List<List<Integer>> adj) { int[] vis = new int[n];
        for (int i = 0;
        i < n;
        i++) if (vis[i] == 0) if (dfs(i, adj, vis)) return true;
        return false;
    } private boolean dfs(int u, List<List<Integer>> adj, int[] vis) { vis[u] = 1;
        for (int v : adj.get(u)) { if (vis[v] == 1) return true;
            if (vis[v] == 0 && dfs(v, adj, vis)) return true;
        } vis[u] = 2;
        return false;
    };
}
