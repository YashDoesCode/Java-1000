
import java.util.*;
public class ReorderRoutesToMakeAllPathsLeadToCityZeroGraph {

    public int minReorder(int n, int[][] connections) { List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0;
        i < n;
        i++) adj.add(new ArrayList<>());
        for (int[] c : connections) { adj.get(c[0]).add(new int[]{c[1], 1});
            adj.get(c[1]).add(new int[]{c[0], 0});
        } return dfs(adj, 0, new boolean[n]);
    } private int dfs(List<List<int[]>> adj, int u, boolean[] vis) { vis[u] = true;
        int change = 0;
        for (int[] nxt : adj.get(u)) { if (!vis[nxt[0]]) change += nxt[1] + dfs(adj, nxt[0], vis);
        } return change;
    };
}
