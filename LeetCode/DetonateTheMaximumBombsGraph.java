
import java.util.*;
public class DetonateTheMaximumBombsGraph {

    public int maximumDetonations(int[][] bombs) { int n = bombs.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0;
        i < n;
        i++) adj.add(new ArrayList<>());
        for (int i = 0;
        i < n;
        i++) for (int j = 0;
        j < n;
        j++) { if (i != j) { long dx = bombs[i][0] - bombs[j][0], dy = bombs[i][1] - bombs[j][1];
                long r = bombs[i][2];
                if (dx * dx + dy * dy <= r * r) adj.get(i).add(j);
            } } int maxV = 0;
        for (int i = 0;
        i < n;
        i++) maxV = Math.max(maxV, bfs(adj, i, n));
        return maxV;
    } private int bfs(List<List<Integer>> adj, int start, int n) { Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(start);
        vis[start] = true;
        int cnt = 0;
        while (!q.isEmpty()) { int cur = q.poll();
            cnt++;
            for (int nxt : adj.get(cur)) if (!vis[nxt]) { vis[nxt] = true;
                q.add(nxt);
            } } return cnt;
    };
}
