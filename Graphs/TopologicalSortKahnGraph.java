/*
 * Popular Question: Course Schedule II (Topological Sort via Kahn's Algorithm)
 * Source: LeetCode #210 (Medium / Top Interview Classic) & GeeksforGeeks
 *
 * Problem Statement:
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [a_i, b_i] indicates that you must take
 * course b_i first if you want to take course a_i.
 *
 * Return the ordering of courses you should take to finish all courses. If it is impossible to finish all courses,
 * return an empty array.
 * If there are multiple valid answers, return any of them.
 *
 * Example 1:
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after course 0.
 *
 * Constraints:
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= a_i, b_i < numCourses
 * a_i != b_i
 * All the pairs [a_i, b_i] are distinct.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortKahnGraph {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            int dest = pre[0];
            int src = pre[1];
            adj.get(src).add(dest);
            inDegree[dest]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order[index++] = current;

            for (int neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (index == numCourses) {
            return order;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        TopologicalSortKahnGraph solver = new TopologicalSortKahnGraph();

        int numCourses1 = 4;
        int[][] pre1 = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        int numCourses2 = 2;
        int[][] pre2 = {
            {1, 0},
            {0, 1}
        };

        int[] res1 = solver.findOrder(numCourses1, pre1);
        int[] res2 = solver.findOrder(numCourses2, pre2);

        System.out.println("Course Schedule Order Test 1: " + Arrays.toString(res1));
        System.out.println("Course Schedule Order Test 2 (Cycle): " + Arrays.toString(res2));
    }
}
