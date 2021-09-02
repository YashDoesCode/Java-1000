/*
 * Popular Question: Network Delay Time (Dijkstra's Shortest Path Algorithm)
 * Source: LeetCode #743 (Medium) & Classic Graph Theory
 *
 * Problem Statement:
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times
 * as directed edges times[i] = (u_i, v_i, w_i), where u_i is the source node, v_i is the target node,
 * and w_i is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal.
 * If it is impossible for all the n nodes to receive the signal, return -1.
 *
 * Example 1:
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 *
 * Constraints:
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= u_i, v_i <= n
 * u_i != v_i
 * 0 <= w_i <= 100
 * All the pairs (u_i, v_i) are unique.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithmGraph {

    private static class Edge {
        int target;
        int weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new Edge(v, w));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int d = current[1];

            if (d > dist[u]) {
                continue;
            }

            for (Edge edge : adj.get(u)) {
                int v = edge.target;
                int weight = edge.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxDelay = Math.max(maxDelay, dist[i]);
        }

        return maxDelay;
    }

    public static void main(String[] args) {
        DijkstraAlgorithmGraph solver = new DijkstraAlgorithmGraph();

        int[][] times1 = {
            {2, 1, 1},
            {2, 3, 1},
            {3, 4, 1}
        };
        int n1 = 4;
        int k1 = 2;

        int[][] times2 = {
            {1, 2, 1}
        };
        int n2 = 2;
        int k2 = 1;

        int res1 = solver.networkDelayTime(times1, n1, k1);
        int res2 = solver.networkDelayTime(times2, n2, k2);

        System.out.println("Network Delay Time Test 1: " + res1);
        System.out.println("Network Delay Time Test 2: " + res2);
    }
}
