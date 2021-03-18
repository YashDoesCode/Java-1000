
import java.util.*;
public class MinimumScoreOfAPathBetweenTwoCitiesGraph {

    public int minScore(int n, int[][] roads) { List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0;
        i <= n;
        i++) adj.add(new ArrayList<>());
        for (int[] r : roads) { adj.get(r[0]).add(new int[]{r[1], r[2]});
            adj.get(r[1]).add(new int[]{r[0], r[2]});
        } boolean[] vis = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1] = true;
        int minV = Integer.MAX_VALUE;
        while (!q.isEmpty()) { int u = q.poll();
            for (int[] nxt : adj.get(u)) { minV = Math.min(minV, nxt[1]);
                if (!vis[nxt[0]]) { vis[nxt[0]] = true;
                    q.add(nxt[0]);
                } } } return minV;
    };
}
