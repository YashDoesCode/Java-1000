public class MatrixBlockSum2D {

    public int[][] blockSum(int[][] mat, int k) { int r = mat.length, c = mat[0].length;
        int[][] p = new int[r + 1][c + 1];
        for (int i = 0;
        i < r;
        i++) for (int j = 0;
        j < c;
        j++) p[i + 1][j + 1] = p[i + 1][j] + p[i][j + 1] - p[i][j] + mat[i][j];
        int[][] res = new int[r][c];
        for (int i = 0;
        i < r;
        i++) for (int j = 0;
        j < c;
        j++) { int r1 = Math.max(0, i - k), c1 = Math.max(0, j - k);
            int r2 = Math.min(r - 1, i + k), c2 = Math.min(c - 1, j + k);
            res[i][j] = p[r2 + 1][c2 + 1] - p[r1][c2 + 1] - p[r2 + 1][c1] + p[r1][c1];
        } return res;
    };
}
