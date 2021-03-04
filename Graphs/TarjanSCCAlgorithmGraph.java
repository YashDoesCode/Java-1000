import java.util.*;
public class TarjanSCCAlgorithmGraph {

    private int timer = 0;

    public List<List<Integer>> tarjan(int n, List<List<Integer>> adj) { int[] disc = new int[n], low = new int[n];
        Arrays.fill(disc, -1);
        boolean[] inSt = new boolean[n];
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> sccs = new ArrayList<>();
        for (int i = 0;
        i < n;
        i++) if (disc[i] == -1) dfs(i, adj, disc, low, st, inSt, sccs);
        return sccs;
    } private void dfs(int u, List<List<Integer>> adj, int[] disc, int[] low, Stack<Integer> st, boolean[] inSt, List<List<Integer>> sccs) { disc[u] = low[u] = ++timer;
        st.push(u);
        inSt[u] = true;
        for (int v : adj.get(u)) { if (disc[v] == -1) { dfs(v, adj, disc, low, st, inSt, sccs);
                low[u] = Math.min(low[u], low[v]);
            } else if (inSt[v]) low[u] = Math.min(low[u], disc[v]);
        } if (low[u] == disc[u]) { List<Integer> scc = new ArrayList<>();
            while (true) { int v = st.pop();
                inSt[v] = false;
                scc.add(v);
                if (u == v) break;
            } sccs.add(scc);
        } };
}
