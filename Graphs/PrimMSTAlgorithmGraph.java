import java.util.*;
public class PrimMSTAlgorithmGraph {

    public int prim(int n, List<List<int[]>> adj) { boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{0, 0});
        int mstCost = 0;
        while (!pq.isEmpty()) { int[] cur = pq.poll();
            int u = cur[0], w = cur[1];
            if (vis[u]) continue;
            vis[u] = true;
            mstCost += w;
            for (int[] edge : adj.get(u)) if (!vis[edge[0]]) pq.add(edge);
        } return mstCost;
    };
}
