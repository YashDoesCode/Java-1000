/*
 * Popular Question: Shortest Path in a 3D Dungeon Matrix (BFS)
 * Source: Popular Competitive Programming & LeetCode 1091 (3D Extension)
 *
 * Problem Statement:
 * Given an X x Y x Z 3D grid representing a 3D dungeon where each cell can be:
 *   - 0: An empty voxel that you can walk through.
 *   - 1: A blocked voxel representing a solid wall.
 *
 * You start at the top-left-front voxel (0, 0, 0) and wish to reach the bottom-right-back voxel (X-1, Y-1, Z-1).
 * You can move in 6 directions (up, down, left, right, forward, backward) to adjacent empty voxels (sharing a face).
 * Return the minimum number of steps required to reach the target voxel. If no path exists, return -1.
 *
 * Example 1:
 * Input: grid = [
 *   [[0, 0], [0, 1]],
 *   [[1, 0], [0, 0]]
 * ]
 * Output: 3
 * Explanation: (0,0,0) -> (0,1,0) -> (1,1,0) -> (1,1,1) is a path of 3 steps.
 *
 * Constraints:
 * 1 <= X, Y, Z <= 50
 * grid[i][j][k] is either 0 or 1.
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPath3DBFS {

    public int shortestPath(int[][][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0].length == 0) {
            return -1;
        }

        int xLen = grid.length;
        int yLen = grid[0].length;
        int zLen = grid[0][0].length;

        if (grid[0][0][0] == 1 || grid[xLen - 1][yLen - 1][zLen - 1] == 1) {
            return -1;
        }

        if (xLen == 1 && yLen == 1 && zLen == 1) {
            return 0;
        }

        boolean[][][] visited = new boolean[xLen][yLen][zLen];
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        int[][] directions = {
            {1, 0, 0}, {-1, 0, 0},
            {0, 1, 0}, {0, -1, 0},
            {0, 0, 1}, {0, 0, -1}
        };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int cz = current[2];
            int dist = current[3];

            if (cx == xLen - 1 && cy == yLen - 1 && cz == zLen - 1) {
                return dist;
            }

            for (int[] dir : directions) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];
                int nz = cz + dir[2];

                if (nx >= 0 && nx < xLen && ny >= 0 && ny < yLen && nz >= 0 && nz < zLen) {
                    if (!visited[nx][ny][nz] && grid[nx][ny][nz] == 0) {
                        visited[nx][ny][nz] = true;
                        queue.offer(new int[]{nx, ny, nz, dist + 1});
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ShortestPath3DBFS solver = new ShortestPath3DBFS();

        int[][][] grid1 = {
            {{0, 0}, {0, 1}},
            {{1, 0}, {0, 0}}
        };

        int[][][] grid2 = {
            {{0, 1}, {1, 1}},
            {{1, 1}, {1, 0}}
        };

        int result1 = solver.shortestPath(grid1);
        int result2 = solver.shortestPath(grid2);

        System.out.println("Test Case 1 Shortest Path: " + result1);
        System.out.println("Test Case 2 Shortest Path: " + result2);
    }
}
