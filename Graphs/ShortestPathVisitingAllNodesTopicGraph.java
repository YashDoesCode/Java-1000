import java.util.*;
public class ShortestPathVisitingAllNodesTopicGraph {

    public int shortestPathLength(int[][] graph) { int n = graph.length;
        if (n == 1) return 0;
        int finalState = (1 << n) - 1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][1 << n];
        for (int i = 0;
        i < n;
        i++) { q.add(new int[]{i, 1 << i, 0});
            vis[i][1 << i] = true;
        } while (!q.isEmpty()) { int[] cur = q.poll();
            int u = cur[0], mask = cur[1], d = cur[2];
            if (mask == finalState) return d;
            for (int v : graph[u]) { int nextMask = mask | (1 << v);
                if (!vis[v][nextMask]) { vis[v][nextMask] = true;
                    q.add(new int[]{v, nextMask, d + 1});
                } } } return -1;
    };
}
