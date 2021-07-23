import java.util.*;

public class KruskalMstGraph {

    public static class Edge implements Comparable<Edge> {

        public int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public int kruskalMST(int vertices, List<Edge> edges) {
        Collections.sort(edges);
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) parent[i] = i;
        int mstWeight = 0, count = 0;
        for (Edge edge : edges) {
            int rootSrc = find(parent, edge.src);
            int rootDest = find(parent, edge.dest);
            if (rootSrc != rootDest) {
                mstWeight += edge.weight;
                parent[rootSrc] = rootDest;
                count++;
                if (count == vertices - 1) break;
            }
        }
        return mstWeight;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }
}
