import java.util.*;
public class BipartiteGraphCheck {

    public boolean isBipartite(int[][] graph) { int n = graph.length;
        int[] color = new int[n];
        for (int i = 0;
        i < n;
        i++) { if (color[i] == 0) { Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 1;
                while (!q.isEmpty()) { int u = q.poll();
                    for (int v : graph[u]) { if (color[v] == 0) { color[v] = -color[u];
                            q.add(v);
                        } else if (color[v] == color[u]) return false;
                    } } } } return true;
    };
}
