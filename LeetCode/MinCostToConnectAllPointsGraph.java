
import java.util.*;
public class MinCostToConnectAllPointsGraph {

    public int minCostConnectPoints(int[][] points) { int n = points.length, cost = 0;
        boolean[] vis = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 0;
        i < n;
        i++) { int u = -1;
            for (int j = 0;
            j < n;
            j++) if (!vis[j] && (u == -1 || dist[j] < dist[u])) u = j;
            vis[u] = true;
            cost += dist[u];
            for (int v = 0;
            v < n;
            v++) { if (!vis[v]) { int d = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    dist[v] = Math.min(dist[v], d);
                } } } return cost;
    };
}
