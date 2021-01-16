public class DiagonalSum2D {

    public int diagonalSum(int[][] m) { int n = m.length, sum = 0;
        for (int i = 0;
        i < n;
        i++) { sum += m[i][i];
            if (i != n - 1 - i) sum += m[i][n - 1 - i];
        } return sum;
    };
}
