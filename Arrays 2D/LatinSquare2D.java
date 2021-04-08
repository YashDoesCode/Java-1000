public class LatinSquare2D {

    public boolean isLatinSquare(int[][] m) { int n = m.length;
        for (int i = 0;
        i < n;
        i++) { boolean[] rVis = new boolean[n + 1], cVis = new boolean[n + 1];
            for (int j = 0;
            j < n;
            j++) { if (m[i][j] < 1 || m[i][j] > n || rVis[m[i][j]]) return false;
                rVis[m[i][j]] = true;
                if (m[j][i] < 1 || m[j][i] > n || cVis[m[j][i]]) return false;
                cVis[m[j][i]] = true;
            } } return true;
    };
}
