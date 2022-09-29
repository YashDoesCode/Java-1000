
import java.util.*;
public class NetworkDelayTimeGraph {

    public int networkDelayTime(int[][] times, int n, int k) { Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] t : times) { adj.putIfAbsent(t[0], new ArrayList<>());
            adj.get(t[0]).add(new int[]{t[1], t[2]});
        } PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{k, 0});
        Map<Integer, Integer> dist = new HashMap<>();
        while (!pq.isEmpty()) { int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (dist.containsKey(u)) continue;
            dist.put(u, d);
            if (adj.containsKey(u)) { for (int[] edge : adj.get(u)) if (!dist.containsKey(edge[0])) pq.add(new int[]{edge[0], d + edge[1]});
            } } if (dist.size() != n) return -1;
        int maxV = 0;
        for (int d : dist.values()) maxV = Math.max(maxV, d);
        return maxV;
    };
}
