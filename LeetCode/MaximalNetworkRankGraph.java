
public class MaximalNetworkRankGraph {

    public int maximalNetworkRank(int n, int[][] roads) { int[] deg = new int[n];
        boolean[][] connected = new boolean[n][n];
        for (int[] r : roads) { deg[r[0]]++;
            deg[r[1]]++;
            connected[r[0]][r[1]] = true;
            connected[r[1]][r[0]] = true;
        } int maxR = 0;
        for (int i = 0;
        i < n;
        i++) for (int j = i + 1;
        j < n;
        j++) { int rank = deg[i] + deg[j] - (connected[i][j] ? 1 : 0);
            maxR = Math.max(maxR, rank);
        } return maxR;
    };
}
