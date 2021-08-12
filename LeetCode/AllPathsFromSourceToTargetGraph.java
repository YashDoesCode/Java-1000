
import java.util.*;
public class AllPathsFromSourceToTargetGraph {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) { List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, res);
        return res;
    } private void dfs(int[][] g, int u, List<Integer> path, List<List<Integer>> res) { if (u == g.length - 1) { res.add(new ArrayList<>(path));
            return;
        } for (int v : g[u]) { path.add(v);
            dfs(g, v, path, res);
            path.remove(path.size() - 1);
        } };
}
