import java.util.*;
public class KruskalMSTAlgorithmGraph {

    public int kruskal(int n, int[][] edges) { Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        int[] parent = new int[n];
        for (int i = 0;
        i < n;
        i++) parent[i] = i;
        int mstCost = 0, count = 0;
        for (int[] e : edges) { int r1 = find(parent, e[0]), r2 = find(parent, e[1]);
            if (r1 != r2) { parent[r1] = r2;
                mstCost += e[2];
                if (++count == n - 1) break;
            } } return mstCost;
    } private int find(int[] p, int i) { return p[i] == i ? i : (p[i] = find(p, p[i]));
    };
}
