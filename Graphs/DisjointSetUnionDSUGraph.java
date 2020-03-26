public class DisjointSetUnionDSUGraph {

    private int[] parent, rank;

    public DisjointSetUnionDSUGraph(int n) { parent = new int[n];
        rank = new int[n];
        for (int i = 0;
        i < n;
        i++) parent[i] = i;
    } public int find(int i) { return parent[i] == i ? i : (parent[i] = find(parent[i]));
    } public boolean union(int i, int j) { int r1 = find(i), r2 = find(j);
        if (r1 == r2) return false;
        if (rank[r1] < rank[r2]) parent[r1] = r2;
        else if (rank[r1] > rank[r2]) parent[r2] = r1;
        else { parent[r2] = r1;
            rank[r1]++;
        } return true;
    };
}
