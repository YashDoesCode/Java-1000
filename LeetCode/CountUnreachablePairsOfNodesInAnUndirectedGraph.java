
import java.util.*;
public class CountUnreachablePairsOfNodesInAnUndirectedGraph {

    public long countPairs(int n, int[][] edges) { List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;
        i < n;
        i++) adj.add(new ArrayList<>());
        for (int[] e : edges) { adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        } boolean[] vis = new boolean[n];
        long remaining = n, ans = 0;
        for (int i = 0;
        i < n;
        i++) { if (!vis[i]) { long size = dfs(adj, i, vis);
                ans += size * (remaining - size);
                remaining -= size;
            } } return ans;
    } private long dfs(List<List<Integer>> adj, int u, boolean[] vis) { vis[u] = true;
        long count = 1;
        for (int v : adj.get(u)) if (!vis[v]) count += dfs(adj, v, vis);
        return count;
    };
}
