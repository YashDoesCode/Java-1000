import java.util.*;
public class KosarajuSCCAlgorithmGraph {

    public List<List<Integer>> kosaraju(int n, List<List<Integer>> adj) { Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];
        for (int i = 0;
        i < n;
        i++) if (!vis[i]) dfs1(i, adj, vis, st);
        List<List<Integer>> rev = new ArrayList<>();
        for (int i = 0;
        i < n;
        i++) rev.add(new ArrayList<>());
        for (int u = 0;
        u < n;
        u++) for (int v : adj.get(u)) rev.get(v).add(u);
        Arrays.fill(vis, false);
        List<List<Integer>> sccs = new ArrayList<>();
        while (!st.isEmpty()) { int u = st.pop();
            if (!vis[u]) { List<Integer> scc = new ArrayList<>();
                dfs2(u, rev, vis, scc);
                sccs.add(scc);
            } } return sccs;
    } private void dfs1(int u, List<List<Integer>> adj, boolean[] vis, Stack<Integer> st) { vis[u] = true;
        for (int v : adj.get(u)) if (!vis[v]) dfs1(v, adj, vis, st);
        st.push(u);
    } private void dfs2(int u, List<List<Integer>> rev, boolean[] vis, List<Integer> scc) { vis[u] = true;
        scc.add(u);
        for (int v : rev.get(u)) if (!vis[v]) dfs2(v, rev, vis, scc);
    };
}
