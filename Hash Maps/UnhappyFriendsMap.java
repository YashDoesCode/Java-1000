import java.util.*;
public class UnhappyFriendsMap {

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) { int[][] rank = new int[n][n];
        for (int i = 0;
        i < n;
        i++) for (int j = 0;
        j < n - 1;
        j++) rank[i][preferences[i][j]] = j;
        int[] match = new int[n];
        for (int[] p : pairs) { match[p[0]] = p[1];
            match[p[1]] = p[0];
        } int ans = 0;
        for (int x = 0;
        x < n;
        x++) { int y = match[x];
            int r = rank[x][y];
            for (int i = 0;
            i < r;
            i++) { int u = preferences[x][i];
                int v = match[u];
                if (rank[u][x] < rank[u][v]) { ans++;
                    break;
                } } } return ans;
    };
}
