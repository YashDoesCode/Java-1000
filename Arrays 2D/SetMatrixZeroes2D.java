public class SetMatrixZeroes2D {

    public void setZeroes(int[][] m) { int r = m.length, c = m[0].length;
        boolean col0 = false;
        for (int i = 0;
        i < r;
        i++) { if (m[i][0] == 0) col0 = true;
            for (int j = 1;
            j < c;
            j++) if (m[i][j] == 0) { m[i][0] = 0;
                m[0][j] = 0;
            } } for (int i = r - 1;
        i >= 0;
        i--) { for (int j = c - 1;
            j >= 1;
            j--) if (m[i][0] == 0 || m[0][j] == 0) m[i][j] = 0;
            if (col0) m[i][0] = 0;
        } };
}
