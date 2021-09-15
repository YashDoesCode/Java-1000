
public class MatrixExponentiationMath {

    public int[][] multiply(int[][] a, int[][] b) { int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0;
        i < n;
        i++) for (int j = 0;
        j < n;
        j++) for (int k = 0;
        k < n;
        k++) c[i][j] += a[i][k] * b[k][j];
        return c;
    };
}
