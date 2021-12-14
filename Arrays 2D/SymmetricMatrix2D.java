public class SymmetricMatrix2D {

    public boolean isSymmetric(int[][] m) { int n = m.length;
        for (int i = 0;
        i < n;
        i++) for (int j = 0;
        j < n;
        j++) if (m[i][j] != m[j][i]) return false;
        return true;
    };
}
