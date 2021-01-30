public class MatrixMultiplication2D {

    public int[][] multiply(int[][] a, int[][] b) { int r1 = a.length, c1 = a[0].length, c2 = b[0].length;
        int[][] res = new int[r1][c2];
        for (int i = 0;
        i < r1;
        i++) for (int j = 0;
        j < c2;
        j++) for (int k = 0;
        k < c1;
        k++) res[i][j] += a[i][k] * b[k][j];
        return res;
    };
}
