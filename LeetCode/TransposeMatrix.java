
public class TransposeMatrix {

    public int[][] transpose(int[][] m) { int r = m.length, c = m[0].length;
        int[][] res = new int[c][r];
        for (int i = 0;
        i < r;
        i++) for (int j = 0;
        j < c;
        j++) res[j][i] = m[i][j];
        return res;
    };
}
