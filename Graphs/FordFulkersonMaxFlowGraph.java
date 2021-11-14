import java.util.*;
public class FordFulkersonMaxFlowGraph {

    public int fordFulkerson(int[][] graph, int s, int t, int V) { int u, v;
        int[][] rGraph = new int[V][V];
        for (u = 0; u < V; u++) {
            for (v = 0; v < V; v++) {
                rGraph[u][v] = graph[u][v];
            }
        }
        int[] parent = new int[V];
        int maxFlow = 0;
        while (bfs(rGraph, s, t, parent, V)) { int pathFlow = Integer.MAX_VALUE;
            for (v = t;
            v != s;
            v = parent[v]) { u = parent[v];
                pathFlow = Math.min(pathFlow, rGraph[u][v]);
            } for (v = t;
            v != s;
            v = parent[v]) { u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            } maxFlow += pathFlow;
        } return maxFlow;
    } private boolean bfs(int[][] rGraph, int s, int t, int[] parent, int V) { boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        vis[s] = true;
        parent[s] = -1;
        while (!q.isEmpty()) { int u = q.poll();
            for (int v = 0;
            v < V;
            v++) if (!vis[v] && rGraph[u][v] > 0) { if (v == t) { parent[v] = u;
                    return true;
                } q.add(v);
                parent[v] = u;
                vis[v] = true;
            } } return false;
    };
}
