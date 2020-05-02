import java.util.*;

public class BipartiteGraphChecker {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            colors[i] = 1;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {
                        colors[next] = -colors[cur];
                        q.offer(next);
                    } else if (colors[next] != -colors[cur]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
