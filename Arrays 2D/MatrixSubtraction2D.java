public class MatrixSubtraction2D {

    public int[][] sub(int[][] a, int[][] b) { int r = a.length, c = a[0].length;
        int[][] res = new int[r][c];
        for (int i = 0;
        i < r;
        i++) for (int j = 0;
        j < c;
        j++) res[i][j] = a[i][j] - b[i][j];
        return res;
    };
}
