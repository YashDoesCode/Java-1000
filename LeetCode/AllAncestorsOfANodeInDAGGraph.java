
import java.util.*;
public class AllAncestorsOfANodeInDAGGraph {

    public List<List<Integer>> getAncestors(int n, int[][] edges) { List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;
        i < n;
        i++) { res.add(new ArrayList<>());
            adj.add(new ArrayList<>());
        } for (int[] e : edges) adj.get(e[0]).add(e[1]);
        for (int i = 0;
        i < n;
        i++) dfs(i, i, adj, res, new boolean[n]);
        return res;
    } private void dfs(int p, int u, List<List<Integer>> adj, List<List<Integer>> res, boolean[] vis) { vis[u] = true;
        for (int v : adj.get(u)) { if (!vis[v]) { res.get(v).add(p);
                dfs(p, v, adj, res, vis);
            } } };
}
