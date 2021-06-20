
import java.util.*;
public class NetworkDelayGraph {

    public int networkDelayTime(int[][] times, int n, int k) { int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        for (int i = 1;
        i <= n;
        i++) { for (int[] t : times) { int u = t[0], v = t[1], w = t[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) dist[v] = dist[u] + w;
            } } int maxV = 0;
        for (int i = 1;
        i <= n;
        i++) { if (dist[i] == Integer.MAX_VALUE) return -1;
            maxV = Math.max(maxV, dist[i]);
        } return maxV;
    };
}
