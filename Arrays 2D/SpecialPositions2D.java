public class SpecialPositions2D {

    public int numSpecial(int[][] mat) { int m = mat.length, n = mat[0].length;
        int[] r = new int[m], c = new int[n];
        for (int i = 0;
        i < m;
        i++) for (int j = 0;
        j < n;
        j++) if (mat[i][j] == 1) { r[i]++;
            c[j]++;
        } int cnt = 0;
        for (int i = 0;
        i < m;
        i++) for (int j = 0;
        j < n;
        j++) if (mat[i][j] == 1 && r[i] == 1 && c[j] == 1) cnt++;
        return cnt;
    };
}
