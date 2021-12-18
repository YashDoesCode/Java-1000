import java.util.*;
public class DFSGraphTraversal {

    public List<Integer> dfs(int n, List<List<Integer>> adj, int start) { List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[n];
        dfsRec(start, adj, vis, res);
        return res;
    } private void dfsRec(int u, List<List<Integer>> adj, boolean[] vis, List<Integer> res) { vis[u] = true;
        res.add(u);
        for (int v : adj.get(u)) if (!vis[v]) dfsRec(v, adj, vis, res);
    };
}
