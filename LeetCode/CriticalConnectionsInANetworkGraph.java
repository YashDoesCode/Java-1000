
import java.util.*;
public class CriticalConnectionsInANetworkGraph {

    private int timer = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) { List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;
        i < n;
        i++) adj.add(new ArrayList<>());
        for (List<Integer> c : connections) { adj.get(c.get(0)).add(c.get(1));
            adj.get(c.get(1)).add(c.get(0));
        } int[] disc = new int[n], low = new int[n];
        Arrays.fill(disc, -1);
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, -1, disc, low, adj, res);
        return res;
    } private void dfs(int u, int p, int[] disc, int[] low, List<List<Integer>> adj, List<List<Integer>> res) { disc[u] = low[u] = ++timer;
        for (int v : adj.get(u)) { if (v == p) continue;
            if (disc[v] != -1) low[u] = Math.min(low[u], disc[v]);
            else { dfs(v, u, disc, low, adj, res);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) res.add(Arrays.asList(u, v));
            } } };
}
