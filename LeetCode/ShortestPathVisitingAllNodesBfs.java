import java.util.*;

public class ShortestPathVisitingAllNodesBfs {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int endingMask = (1 << n) - 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][1 << n];

        for (int i = 0; i < n; i++) {
            queue.add(new int[]{i, 1 << i});
            visited[i][1 << i] = true;
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int mask = curr[1];

                if (mask == endingMask) return steps;

                for (int neighbor : graph[node]) {
                    int nextMask = mask | (1 << neighbor);
                    if (!visited[neighbor][nextMask]) {
                        visited[neighbor][nextMask] = true;
                        queue.add(new int[]{neighbor, nextMask});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
