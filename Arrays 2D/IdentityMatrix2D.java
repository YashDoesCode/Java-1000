public class IdentityMatrix2D {

    public boolean isIdentity(int[][] m) { int n = m.length;
        for (int i = 0;
        i < n;
        i++) for (int j = 0;
        j < n;
        j++) { if (i == j && m[i][j] != 1) return false;
            if (i != j && m[i][j] != 0) return false;
        } return true;
    };
}
