import java.util.*;

public class TarjanStronglyConnectedComponents {

    private int index = 0;
    private final List<List<Integer>> sccs = new ArrayList<>();

    public List<List<Integer>> getSCCs(int n, List<List<Integer>> adj) {
        int[] ids = new int[n];
        int[] low = new int[n];
        boolean[] onStack = new boolean[n];
        Arrays.fill(ids, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (ids[i] == -1) dfs(i, adj, ids, low, onStack, stack);
        }
        return sccs;
    }

    private void dfs(int u, List<List<Integer>> adj, int[] ids, int[] low, boolean[] onStack, Stack<Integer> stack) {
        ids[u] = low[u] = index++;
        stack.push(u);
        onStack[u] = true;
        for (int v : adj.get(u)) {
            if (ids[v] == -1) {
                dfs(v, adj, ids, low, onStack, stack);
                low[u] = Math.min(low[u], low[v]);
            } else if (onStack[v]) {
                low[u] = Math.min(low[u], ids[v]);
            }
        }
        if (ids[u] == low[u]) {
            List<Integer> component = new ArrayList<>();
            while (true) {
                int node = stack.pop();
                onStack[node] = false;
                component.add(node);
                if (node == u) break;
            }
            sccs.add(component);
        }
    }
}
