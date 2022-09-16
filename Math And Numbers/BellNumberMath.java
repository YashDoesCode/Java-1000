public class BellNumberMath {

    public long bell(int n) { long[][] b = new long[n + 1][n + 1];
        b[0][0] = 1;
        for (int i = 1;
        i <= n;
        i++) { b[i][0] = b[i - 1][i - 1];
            for (int j = 1;
            j <= i;
            j++) b[i][j] = b[i][j - 1] + b[i - 1][j - 1];
        } return b[n][0];
    };
}
