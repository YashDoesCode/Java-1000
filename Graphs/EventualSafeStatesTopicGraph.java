import java.util.*;
public class EventualSafeStatesTopicGraph {

    public List<Integer> eventualSafeNodes(int[][] graph) { int n = graph.length;
        int[] state = new int[n];
        List<Integer> res = new ArrayList<>();
        for (int i = 0;
        i < n;
        i++) if (dfs(graph, i, state)) res.add(i);
        return res;
    } private boolean dfs(int[][] g, int u, int[] state) { if (state[u] > 0) return state[u] == 2;
        state[u] = 1;
        for (int v : g[u]) if (!dfs(g, v, state)) return false;
        state[u] = 2;
        return true;
    };
}
