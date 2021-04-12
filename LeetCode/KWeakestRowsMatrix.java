
import java.util.*;
public class KWeakestRowsMatrix {

    public int[] kWeakestRows(int[][] mat, int k) { int r = mat.length, c = mat[0].length;
        int[][] s = new int[r][2];
        for (int i = 0;
        i < r;
        i++) { int cnt = 0;
            for (int j = 0;
            j < c;
            j++) cnt += mat[i][j];
            s[i][0] = cnt;
            s[i][1] = i;
        } Arrays.sort(s, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int[] res = new int[k];
        for (int i = 0;
        i < k;
        i++) res[i] = s[i][1];
        return res;
    };
}
