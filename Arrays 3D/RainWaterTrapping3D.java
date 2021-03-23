/*
 * Popular Question: Trapping Rain Water II (3D Surface Elevation Map)
 * Source: LeetCode #407 (Hard)
 *
 * Problem Statement:
 * Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map
 * (which forms a 3D terrain surface), return the volume of water it can trap after raining.
 *
 * Water can flow to neighboring cells (up, down, left, right) if the height of the neighbor is less than or equal to
 * the current cell's water level. Water will spill over the boundary of the grid if not contained.
 *
 * Example 1:
 * Input: heightMap = [
 *   [1,4,3,1,3,2],
 *   [3,2,1,3,2,4],
 *   [2,3,3,2,3,1]
 * ]
 * Output: 4
 * Explanation: After the rain, water is trapped between the boundary blocks. Total volume trapped is 4 units.
 *
 * Constraints:
 * m == heightMap.length
 * n == heightMap[i].length
 * 1 <= m, n <= 200
 * 0 <= heightMap[i][j] <= 2 * 10^4
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class RainWaterTrapping3D {

    private static class Cell {
        int row;
        int col;
        int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m < 3 || n < 3) {
            return 0;
        }

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.height));

        for (int r = 0; r < m; r++) {
            pq.offer(new Cell(r, 0, heightMap[r][0]));
            pq.offer(new Cell(r, n - 1, heightMap[r][n - 1]));
            visited[r][0] = true;
            visited[r][n - 1] = true;
        }

        for (int c = 1; c < n - 1; c++) {
            pq.offer(new Cell(0, c, heightMap[0][c]));
            pq.offer(new Cell(m - 1, c, heightMap[m - 1][c]));
            visited[0][c] = true;
            visited[m - 1][c] = true;
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int totalWater = 0;

        while (!pq.isEmpty()) {
            Cell current = pq.poll();

            for (int[] dir : directions) {
                int nr = current.row + dir[0];
                int nc = current.col + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    totalWater += Math.max(0, current.height - heightMap[nr][nc]);
                    pq.offer(new Cell(nr, nc, Math.max(heightMap[nr][nc], current.height)));
                }
            }
        }

        return totalWater;
    }

    public static void main(String[] args) {
        RainWaterTrapping3D solver = new RainWaterTrapping3D();

        int[][] terrain = {
            {1, 4, 3, 1, 3, 2},
            {3, 2, 1, 3, 2, 4},
            {2, 3, 3, 2, 3, 1}
        };

        int trapped = solver.trapRainWater(terrain);
        System.out.println("Total Trapped Water Volume: " + trapped);
    }
}
