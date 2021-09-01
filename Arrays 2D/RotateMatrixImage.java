/*
 * Popular Question: Rotate Image (Rotate Matrix 90 Degrees Clockwise)
 * Source: LeetCode #48 (Medium / Top Interview Classic)
 *
 * Problem Statement:
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 * Input: matrix = [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ]
 * Output: [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * Constraints:
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */

import java.util.Arrays;

public class RotateMatrixImage {

    public void rotateTransposeReverse(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public void rotateLayerByLayer(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }

        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        RotateMatrixImage rot = new RotateMatrixImage();

        int[][] m1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] m2 = {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };

        System.out.println("Original Matrix 1:");
        printMatrix(m1);

        rot.rotateTransposeReverse(m1);

        System.out.println("Rotated Matrix 1 (Clockwise 90deg):");
        printMatrix(m1);

        System.out.println("\nOriginal Matrix 2:");
        printMatrix(m2);

        rot.rotateLayerByLayer(m2);

        System.out.println("Rotated Matrix 2 (Layer Rotation):");
        printMatrix(m2);
    }
}
