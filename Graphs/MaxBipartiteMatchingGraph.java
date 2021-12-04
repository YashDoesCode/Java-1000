public class MaxBipartiteMatchingGraph {

    public int maxBPM(boolean[][] bpGraph, int m, int n) { int[] matchR = new int[n];
        for (int i = 0;
        i < n;
        i++) matchR[i] = -1;
        int result = 0;
        for (int u = 0;
        u < m;
        u++) { boolean[] vis = new boolean[n];
            if (bpm(bpGraph, u, vis, matchR, n)) result++;
        } return result;
    } private boolean bpm(boolean[][] g, int u, boolean[] vis, int[] matchR, int n) { for (int v = 0;
        v < n;
        v++) { if (g[u][v] && !vis[v]) { vis[v] = true;
                if (matchR[v] < 0 || bpm(g, matchR[v], vis, matchR, n)) { matchR[v] = u;
                    return true;
                } } } return false;
    };
}
