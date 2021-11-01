/*
 * Popular Question: Maximum Height by Stacking 3D Cuboids
 * Source: LeetCode #1691 (Hard) & Classic GeeksforGeeks 3D Box Stacking
 *
 * Problem Statement:
 * Given n cuboids where the dimensions of the i-th cuboid are cuboids[i] = [width_i, length_i, height_i] (0-indexed).
 * You can place cuboid i on cuboid j if width_i <= width_j and length_i <= length_j and height_i <= height_j.
 * You can rotate any cuboid so that any side becomes the height, any side becomes the width, and any side becomes the length.
 *
 * Return the maximum height of the stacked cuboids.
 *
 * Example 1:
 * Input: cuboids = [[50,45,20],[95,37,53],[45,23,12]]
 * Output: 190
 * Explanation:
 * Cuboid 1 is placed on the bottom with dimensions [95,37,53] (height 53).
 * Cuboid 0 is placed in the middle with dimensions [50,45,20] (height 50).
 * Cuboid 2 is placed on the top with dimensions [45,23,12] (height 45).
 * Total height is 53 + 50 + 45 = 148 (or rotated optimally to get 190).
 *
 * Constraints:
 * n == cuboids.length
 * 1 <= n <= 100
 * 1 <= width_i, length_i, height_i <= 100
 */

import java.util.Arrays;

public class BoxStacking3DDP {

    public int maxHeight(int[][] cuboids) {
        if (cuboids == null || cuboids.length == 0) {
            return 0;
        }

        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });

        int n = cuboids.length;
        int[] dp = new int[n];
        int maxHeight = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2];
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0] &&
                    cuboids[j][1] <= cuboids[i][1] &&
                    cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        return maxHeight;
    }

    public static void main(String[] args) {
        BoxStacking3DDP solver = new BoxStacking3DDP();

        int[][] cuboids1 = {
            {50, 45, 20},
            {95, 37, 53},
            {45, 23, 12}
        };

        int[][] cuboids2 = {
            {38, 25, 45},
            {76, 35, 3}
        };

        int result1 = solver.maxHeight(cuboids1);
        int result2 = solver.maxHeight(cuboids2);

        System.out.println("Maximum Stacked Height Test 1: " + result1);
        System.out.println("Maximum Stacked Height Test 2: " + result2);
    }
}
