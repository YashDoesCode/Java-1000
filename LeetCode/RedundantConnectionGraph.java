
public class RedundantConnectionGraph {

    public int[] findRedundantConnection(int[][] edges) { int[] parent = new int[edges.length + 1];
        for (int i = 0;
        i < parent.length;
        i++) parent[i] = i;
        for (int[] e : edges) { int root1 = find(parent, e[0]), root2 = find(parent, e[1]);
            if (root1 == root2) return e;
            parent[root1] = root2;
        } return new int[0];
    } private int find(int[] p, int i) { if (p[i] == i) return i;
        return p[i] = find(p, p[i]);
    };
}
