import java.util.*;
public class BFSGraphTraversal {

    public List<Integer> bfs(int n, List<List<Integer>> adj, int start) { List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        while (!q.isEmpty()) { int u = q.poll();
            res.add(u);
            for (int v : adj.get(u)) if (!vis[v]) { vis[v] = true;
                q.add(v);
            } } return res;
    };
}
